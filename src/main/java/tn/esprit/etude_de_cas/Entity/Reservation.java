package tn.esprit.etude_de_cas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Reservation implements Serializable {
    @Id
    private String idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneUniversitaire;
    @Enumerated(EnumType.STRING)
    private Status estValide;

    @ManyToMany
    private List<User> etudiants;

    @ManyToOne
    @JsonIgnore
    private Chambre chambre;
}
