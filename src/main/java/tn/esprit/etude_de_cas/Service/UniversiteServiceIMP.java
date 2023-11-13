package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.University;
import tn.esprit.etude_de_cas.Reposity.UniversityRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceIMP implements IUniversite{
    private UniversityRepo universityRepo;
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
}
