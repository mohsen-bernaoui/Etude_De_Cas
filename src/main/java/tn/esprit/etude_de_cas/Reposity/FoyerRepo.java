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
    @Query("SELECT f.idfFoyer FROM Foyer f JOIN f.universite u WHERE u.idUniversite = :idUniversite ")
    Foyer getFoyerIdFromUniversityTable(@Param("idUniversite ") Long idUniversite);
    Foyer findByIdfFoyer(long idFoyer);
    Foyer findByUniversiteNomUniversity(String nomUni);
    @Query("SELECT f FROM Foyer f WHERE f.universite=:universite AND f.capaciteFoyer > 0")
    List<Foyer> findFoyerWithCapacity(@Param("universite") University universite);


}
