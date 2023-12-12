package tn.esprit.etude_de_cas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idChambre;
    private  long numChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    private long capacity;

    private LocalDateTime lastCleaningDate;
    private LocalDateTime nextScheduledCleaningDate;
    private boolean isCleaningScheduled;

    @ManyToOne
    @JsonIgnore
    private  Bloc bloc;

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;
}
