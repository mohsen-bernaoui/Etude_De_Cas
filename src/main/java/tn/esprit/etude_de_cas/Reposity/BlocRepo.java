package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.etude_de_cas.Entity.Bloc;

public interface BlocRepo extends JpaRepository<Bloc,Long> {
}
