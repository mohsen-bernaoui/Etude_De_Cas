package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Etudiant;
import tn.esprit.etude_de_cas.Reposity.EtudtiantRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceIMP implements IEtudiant {
    private EtudtiantRepo etudtiantRepo;

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudtiantRepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudtiantRepo.save(e);
    }

    @Override
    public List<Etudiant> findallEtudiant() {
        return etudtiantRepo.findAll();
    }

    @Override
    public Etudiant findById(long idE) {
        return etudtiantRepo.findById(idE).orElse(null);
    }

    @Override
    public void deleteEtud(long idE) {
        etudtiantRepo.deleteById(idE);
    }
}
