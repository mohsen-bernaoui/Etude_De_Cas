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
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    @JsonIgnore
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    @JsonIgnore
    private List<Chambre> chambres;

    //Commentaire
}
