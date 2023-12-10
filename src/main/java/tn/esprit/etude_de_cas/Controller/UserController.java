package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Entity.UserUpdateRequest;
import tn.esprit.etude_de_cas.Service.JwtService;
import tn.esprit.etude_de_cas.Service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {



    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/user/update/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable int id,@RequestBody UserUpdateRequest userUpdateRequest) {

        try {
            User user = userUpdateRequest.getUser();
            User currentuser = jwtService.getUser(userUpdateRequest.token);

            if (id==0) {
                throw new RuntimeException("id is required");
            }
            if(currentuser.getId() != id && !currentuser.getRoles().equals("ROLE_ADMIN")) {
                throw new RuntimeException("you are not authorized to update this user");
            }
            user.setId(id);
            userService.updateUser(user);
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "user updated successfully");
            return ResponseEntity.ok().body(successResponse);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/user/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable int id, @RequestBody TokenRequest token) {
        try {
            if (id==0) {
                throw new RuntimeException("id is required");
            }
            User user = jwtService.getUser(token.getToken());
            if(user.getId() != id && !user.getRoles().equals("ROLE_ADMIN")) {
                throw new RuntimeException("you are not authorized to delete this user");
            }
            userService.deleteUser(id);
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "user deleted successfully");
            return ResponseEntity.ok().body(successResponse);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/user/get/{id}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable int id,@RequestBody TokenRequest token) {
        try {
            if (id==0) {
                throw new RuntimeException("id is required");
            }
            User user = jwtService.getUser(token.getToken());
            if(user.getId() != id && !user.getRoles().equals("ROLE_ADMIN")) {
                throw new RuntimeException("you are not authorized to get this user");
            }
            user = userService.getUserById(id);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "user retrieved successfully");
            successResponse.put("data", user);
            return ResponseEntity.ok().body(successResponse);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/user/get-all")
    public ResponseEntity<Map<String, Object>> getAllUsers(@RequestBody TokenRequest token) {
        try {
            User user = jwtService.getUser(token.getToken());
            if(!user.getRoles().equals("ROLE_ADMIN")) {
                throw new RuntimeException("you are not authorized to get all users");
            }
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "users retrieved successfully");
            successResponse.put("data", userService.getAllUsers());
            return ResponseEntity.ok().body(successResponse);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
