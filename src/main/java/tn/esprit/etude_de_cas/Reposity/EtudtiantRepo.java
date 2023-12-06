package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Etudiant;

import java.util.List;

@Repository
public interface EtudtiantRepo extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByIdEtudiant(long idEtudiant);
}
