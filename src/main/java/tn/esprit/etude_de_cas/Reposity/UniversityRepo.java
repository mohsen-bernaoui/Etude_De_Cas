package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.University;
@Repository
public interface UniversityRepo extends JpaRepository<University,Long> {
    University findByNomUniversity(String nomUni);

}
