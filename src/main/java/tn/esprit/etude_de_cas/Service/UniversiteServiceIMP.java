package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.University;
import tn.esprit.etude_de_cas.Reposity.FoyerRepo;
import tn.esprit.etude_de_cas.Reposity.UniversityRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceIMP implements IUniversite{
    public UniversityRepo universityRepo;
    private FoyerRepo foyerRepo;
    @Override
    public List<University> retrieveAllUniversities() {
        return universityRepo.findAll();
    }

    @Override
    public University addUniversite(University university) {
        return universityRepo.save(university);
    }

    @Override
    public University updateUniversite(University university) {
        return universityRepo.save(university);
    }

    @Override
    public University retrieveUniversite(long idUniversite) {
        return universityRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public University addUniversityAndAssignToFoyer(University universite, Foyer foyer) {
        universite.setFoyer(foyer);
        return universityRepo.save(universite);
    }

    @Override
    public University getUniversiteIdFromFoyerTable(long idFoyer) {
        return universityRepo.findByFoyerIdfFoyer(idFoyer);
    }

    @Override
    public University affecterFoyerAUniversite(long idFoyer, String nomUniv) {
        University university=universityRepo.findByNomUniversity(nomUniv);
        if (university == null) {
            throw new RuntimeException("Université non trouvée");
        }
        Foyer foyer = foyerRepo.findByIdfFoyer(idFoyer);
        if (foyer == null) {
            throw new RuntimeException("Foyer deja affecte à une université");
        }

        university.setFoyer(foyer);
        return universityRepo.save(university);
    }


}
