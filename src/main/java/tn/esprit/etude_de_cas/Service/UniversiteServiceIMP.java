package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.University;
import tn.esprit.etude_de_cas.Reposity.FoyerRepo;
import tn.esprit.etude_de_cas.Reposity.UniversityRepo;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteServiceIMP implements IUniversite{
    private UniversityRepo universityRepo;
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




}
