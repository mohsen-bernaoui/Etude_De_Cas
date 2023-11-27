package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.AuthRequest;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Service.JwtService;
import tn.esprit.etude_de_cas.Service.UserInfoService;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
//integrate angular
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {


    private UserInfoService service;


    private JwtService jwtService;


    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {

        return "Welcome to Admin Profile";
    }


   @PostMapping("/generateToken")
   public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
       // Log received credentials
       System.out.println("Received credentials - Username: " + authRequest.getName() + ", Password: " + authRequest.getPassword());

       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));

       // Log authentication details
       System.out.println("Authentication details: " + authentication);

       if (authentication.isAuthenticated()) {
           return jwtService.generateToken(authRequest.getName());
       } else {
           throw new UsernameNotFoundException("Invalid user request!");
       }
   }



}


