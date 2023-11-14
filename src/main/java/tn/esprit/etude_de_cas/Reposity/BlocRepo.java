package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.TypeChambre;

import java.util.Set;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {
    Set<Bloc> findBlocByChambresTypeC(TypeChambre typeC);
}
