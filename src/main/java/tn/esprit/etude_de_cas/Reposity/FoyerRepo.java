package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Foyer;

import java.util.List;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {

    @Query("select f from Foyer f where f.idfFoyer NOT IN ( SELECT u.foyer.idfFoyer from University u WHERE u.foyer IS NOT NULL )")
    List<Foyer> findFoyerNotAffectedToUniversity();
}
