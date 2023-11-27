package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Reposity.EtudtiantRepo;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceIMP implements IEtudiant {
    private EtudtiantRepo etudtiantRepo;

    @Override
    public User addEtudiant(User e) {
        return etudtiantRepo.save(e);
    }

    @Override
    public User updateEtudiant(User e) {
        return etudtiantRepo.save(e);
    }

    @Override
    public List<User> findallEtudiant() {
        return etudtiantRepo.findAll();
    }

    @Override
    public User findById(long idE) {
        return etudtiantRepo.findById(idE).orElse(null);
    }

    @Override
    public void deleteEtud(long idE) {
        etudtiantRepo.deleteById(idE);
    }
}
