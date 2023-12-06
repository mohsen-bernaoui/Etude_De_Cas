package tn.esprit.etude_de_cas.Service;

import org.springframework.data.jpa.repository.Query;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.University;

import java.util.List;

public interface IUniversite {
    List<University> retrieveAllUniversities();

    University addUniversite (University university);

    University updateUniversite (University university);

    University retrieveUniversite (long idUniversite);
    public University addUniversityAndAssignToFoyer(University universite, Foyer foyer);
    public University getUniversiteIdFromFoyerTable(long idFoyer);
    public University affecterFoyerAUniversite(long idFoyer, String nomUniv);


}