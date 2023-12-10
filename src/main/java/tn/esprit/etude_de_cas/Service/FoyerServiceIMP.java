package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.University;
import tn.esprit.etude_de_cas.Reposity.FoyerRepo;
import tn.esprit.etude_de_cas.Reposity.UniversityRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerServiceIMP implements IFoyer{
    @Autowired
    private FoyerRepo foyerRepository;
    private UniversityRepo universityRepo;
    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findallFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long idF) {
        Foyer foyer = foyerRepository.findById(idF).orElse(null);
        if (foyer == null) {
            throw new RuntimeException("Foyer non trouvé");
        }
        if (foyer.getCapaciteFoyer() == 0) {
            return null;
        }
        return foyerRepository.findById(idF).orElse(null);
    }

    @Override
    public void deleteFoyer(long idF) {
        foyerRepository.deleteById(idF);
    }

    @Override
    public Foyer affecterFoyerAUniversite(long idFoyer, String nomUniv) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));

        University universite = universityRepo.findByNomUniversity(nomUniv);
        if (universite == null) {
            throw new RuntimeException("Université non trouvée");
        }
        foyer.setUniversite(universite);
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerIdFromUniversityTable(long idUniversite) {
        return foyerRepository.getFoyerIdFromUniversityTable(idUniversite);
    }

    @Override
    public List<Foyer> getFoyersWithCapacity(String universiteNom) {
        University universite = universityRepo.findByNomUniversity(universiteNom);
        if (universite == null) {
            throw new RuntimeException("Université non trouvée");
        }
        return foyerRepository.findFoyerWithCapacity(universite);
    }
}
