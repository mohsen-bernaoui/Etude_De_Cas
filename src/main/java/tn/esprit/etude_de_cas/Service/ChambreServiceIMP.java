package tn.esprit.etude_de_cas.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Reposity.ChambreRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChambreServiceIMP implements IChambre{
    private ChambreRepo chambreRepo;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        chambre.setLastCleaningDate(LocalDateTime.now());
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }
    @Override
    public Set<Chambre> findChambresByBlocIdBloc(Long idBloc) {
        return chambreRepo.findChambresByBlocIdBloc(idBloc);
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }
}
