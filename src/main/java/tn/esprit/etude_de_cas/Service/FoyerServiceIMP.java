package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Bloc;
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
    public Foyer updateFoyer(Foyer foyer, long idfFoyer) {
        Foyer existingFoyer = foyerRepository.findById(idfFoyer).orElse(null);
        if (existingFoyer != null) {
            existingFoyer.setNomFoyer(foyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(foyer.getCapaciteFoyer());
            return foyerRepository.save(existingFoyer);
        } else {
            return null;
        }
    }

    @Override
    public List<Foyer> findallFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long idF) {
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
        universite.setFoyer(foyer);

        foyerRepository.save(foyer);
        universityRepo.save(universite);

        return foyer;
    }

    @Override
    public List<Foyer> getFoyerNotAffected() {
        return foyerRepository.findFoyerNotAffectedToUniversity();
    }
}

    /*@Override
    public Foyer affecterFoyerAUniversite(long idFoyer, String nomUniv) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));

        University universite = universityRepo.findByNomUniversity(nomUniv);
        if (universite == null) {
            throw new RuntimeException("Université non trouvée");
        }
        foyer.setUniversite(universite);
        return foyerRepository.save(foyer);
    }*/

