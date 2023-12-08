package tn.esprit.etude_de_cas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idChambre;
    private  long numChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    private long capacityChambre;

    @ManyToOne
    @JsonIgnore
    private  Bloc bloc;

    @OneToMany
    private List<Reservation> reservations;
}
