package tn.esprit.etude_de_cas.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    //@Enumerated(EnumType.STRING)
    private String roles;
    private String prenomEt;
    private  long cin;
    private  String ecole;
    @Temporal(TemporalType.DATE)
    private Date dataNaissance;
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private List<Reservation> reservations;

}