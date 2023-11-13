package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.etude_de_cas.Entity.Chambre;

public interface ChambreRepo extends JpaRepository<Chambre,Long> {
}
