package tn.esprit.etude_de_cas.Entity;

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
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  long idfFoyer;
    private  String nomFoyer;
    private  long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private University universite;

    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}
