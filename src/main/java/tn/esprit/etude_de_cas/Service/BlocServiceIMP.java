package tn.esprit.etude_de_cas.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.Etudiant;
import tn.esprit.etude_de_cas.Entity.Reservation;
import tn.esprit.etude_de_cas.Reposity.BlocRepo;
import tn.esprit.etude_de_cas.Reposity.ChambreRepo;
import tn.esprit.etude_de_cas.Reposity.EtudtiantRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceIMP implements IBloc{
    private BlocRepo blocRepo;
    private ChambreRepo chambreRepo;
    private EtudtiantRepo etudtiantRepo;
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc, long idBloc) {

        Bloc existingBloc = blocRepo.findById(idBloc).orElse(null);
        if (existingBloc != null) {
            existingBloc.setNomBloc(bloc.getNomBloc());
            existingBloc.setCapaciteBloc(bloc.getCapaciteBloc());
            return blocRepo.save(existingBloc);
        } else {
            return null;
        }
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public void reserverChambreAvecMiseAJourCapacite(long idBloc, long idChambre, long idEtudiant) {

    }
    public List<Object[]> trouverBlocsAvecNombreReservations() {
        return blocRepo.trouverBlocsAvecNombreReservations();
    }

    @Override
    public List<Object[]> countEtudiantsUniquesParBloc() {
        return blocRepo.countEtudiantsUniquesParBloc();
    }

}