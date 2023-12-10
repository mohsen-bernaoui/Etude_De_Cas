package tn.esprit.etude_de_cas.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {
    private String username;
    private String password;
}