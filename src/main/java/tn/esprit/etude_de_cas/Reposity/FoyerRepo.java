package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.etude_de_cas.Entity.Foyer;

public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
