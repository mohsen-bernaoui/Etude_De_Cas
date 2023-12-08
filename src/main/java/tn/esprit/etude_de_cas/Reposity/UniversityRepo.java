package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.University;
@Repository
public interface UniversityRepo extends JpaRepository<University,Long> {
    University findByNomUniversity(String nomUni);
    @Query("SELECT f.universite FROM Foyer f WHERE f.idfFoyer =: idFoyer")
    University getFoyerIdFromUniversityTable(@Param("idFoyer ") long idFoyer);

    University findByFoyerIdfFoyer(long idFoyer);


}
