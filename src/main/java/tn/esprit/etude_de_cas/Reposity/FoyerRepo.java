package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Foyer;
@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
