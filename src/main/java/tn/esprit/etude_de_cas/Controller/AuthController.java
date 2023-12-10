package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import tn.esprit.etude_de_cas.Entity.AuthRequest;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Service.JwtService;
import tn.esprit.etude_de_cas.Service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                // Generate token
                User user = userService.getUserByName(authRequest.getUsername());

                String token = jwtService.generateToken(user);

                Map<String, String> successResponse = new HashMap<>();
                successResponse.put("status", "success");
                successResponse.put("message", "login successful");
                successResponse.put("token", token);

                return ResponseEntity.ok().body(successResponse);
            }
        } catch (AuthenticationException e) {
            // Handle authentication exception
        }

        // If authentication fails
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "error");
        errorResponse.put("message", "login failed");
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @GetMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestBody TokenRequest token) {
        jwtService.invalidateToken(token.getToken());
        //Invalidate token
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("status", "success");
        successResponse.put("message", "logout successful");
        return ResponseEntity.ok().body(successResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        try {
            User newUser = userService.createUser(user);
            if (newUser == null) {
                throw new Exception();
            }
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "registration successful");
            return ResponseEntity.ok().body(successResponse);
        } catch (Exception e) {
            // If registration fails
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/current-user")
    public ResponseEntity<Map<String, Object>> getCurrentUser(@RequestBody TokenRequest token) {
        try{
            User user = jwtService.getUser(token.getToken());

            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "user retrieved successfully");
            successResponse.put("user", user);
            return ResponseEntity.ok().body(successResponse);
        }catch(NullPointerException e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "no user logged in");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }

    }

}
