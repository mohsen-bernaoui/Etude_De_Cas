package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.University;

import java.util.List;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {

    @Query("select f from Foyer f where f.idfFoyer NOT IN ( SELECT u.foyer.idfFoyer from University u WHERE u.foyer IS NOT NULL )")
    List<Foyer> findFoyerNotAffectedToUniversity();

    @Query ("select f from Foyer f JOIN FETCH f.blocs")
    List<Foyer> findAllFoyersWithBloc();
    @Query("select f from Foyer f where f.universite.foyer.nomFoyer = :foyerId")
    Foyer findFoyerByUniversityId(@Param("foyerId") long idUniversity);
    @Query("SELECT f FROM Foyer f WHERE f.universite=:universite AND f.capaciteFoyer > 0")
    List<Foyer> findFoyerWithCapacity(@Param("universite") University universite);
    Foyer findByIdfFoyer(long idFoyer);

}
