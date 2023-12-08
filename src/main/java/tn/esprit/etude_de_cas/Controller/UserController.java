package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.AuthRequest;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Reposity.UserInfoRepository;
import tn.esprit.etude_de_cas.Service.JwtService;
import tn.esprit.etude_de_cas.Service.UserInfoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
//integrate angular
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {


    private UserInfoService service;
     private UserInfoRepository userInfoRepository;

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

    @PutMapping("/editUser")
    public String editUser(@RequestBody User userInfo) { return service.editUser(userInfo);}


    @GetMapping("/user/userProfile")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {

        return "Welcome to Admin Profile";
    }


   @PostMapping("/generateToken")
   public Map<String, Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
       // Log received credentials
       System.out.println("Received credentials - Username: " + authRequest.getName() + ", Password: " + authRequest.getPassword());

       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));

       // Log authentication details
       System.out.println("Authentication details: " + authentication);
       if (authentication.isAuthenticated()) {
           Optional<User> user = userInfoRepository.findByName(authRequest.getName());
           Map<String, Object> response = new HashMap<>();
           String token = Long.toString(user.get().getCin());
           response.put("token", jwtService.generateToken(
                   Integer.toString(user.get().getId())
                           +'|'+Long.toString( user.get().getCin())
                           +'|'+authRequest.getName()
                           +'|'+user.get().getPrenomEt()
                           +'|'+user.get().getEmail()
                           +'|'+user.get().getDataNaissance()
                           +'|'+user.get().getEcole()
                           +'|'+user.get().getRoles()
           ));
           response.put("role", user.get().getRoles());

           return response;
       } else {
           Map<String, Object> response = new HashMap<>();
           response.put("message", "error");
           return response;
       }
   }



}


