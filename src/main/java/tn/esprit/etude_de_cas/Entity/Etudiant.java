package tn.esprit.etude_de_cas.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private  long cin;
    private  String ecole;
    @Temporal(TemporalType.DATE)
    private Date dataNaissance;

    @ManyToMany(mappedBy = "etudiants")
    private List<Reservation> reservations;
    //baha
}