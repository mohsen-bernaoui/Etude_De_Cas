package tn.esprit.etude_de_cas.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    private String idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneUniversitaire;
    private boolean estValide;

    @ManyToMany
    private List<User> etudiants;
}
