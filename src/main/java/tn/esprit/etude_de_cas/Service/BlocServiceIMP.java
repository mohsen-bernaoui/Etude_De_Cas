package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Reposity.BlocRepo;
import tn.esprit.etude_de_cas.Reposity.ChambreRepo;
import tn.esprit.etude_de_cas.Reposity.FoyerRepo;

import java.util.List;
import java.util.Set;

// les exceptions
import tn.esprit.etude_de_cas.Exceptions.FoyerNotFoundException;
import tn.esprit.etude_de_cas.Exceptions.BlocNotFoundException;
import tn.esprit.etude_de_cas.Exceptions.CapaciteFoyerEpuiseeException;
import tn.esprit.etude_de_cas.Exceptions.BlocDejaReserveException;


@Service
@AllArgsConstructor
public class BlocServiceIMP implements IBloc{
    private BlocRepo blocRepo;
    private ChambreRepo chambreRepo;
    private FoyerRepo foyerRepo;
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
    public Set<Bloc> findBlocByChambresType(TypeChambre typeC) {
        return blocRepo.findBlocByChambresTypeC(typeC);
    }

    @Override
    public Bloc findBlocByChambresIdChambre(long idChambre) {
        return blocRepo.findBlocByChambresIdChambre(idChambre);
    }

    @Override
    public Bloc findBlocById(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public int trouverNombreReservationsParBloc(long idBloc) {
        return blocRepo.trouverNombreReservationsParBloc(idBloc);
    }
    @Override
    public int compterChambresParBloc(long idBloc) {
        return chambreRepo.countChambresByBlocId(idBloc);
    }

    @Override
    public void assignBlocToFoyer(Long idfFoyer, Long idBloc) {
        Foyer foyer = foyerRepo.findById(idfFoyer).orElseThrow(FoyerNotFoundException::new);
        Bloc bloc = blocRepo.findById(idfFoyer).orElseThrow(BlocNotFoundException::new);
        if (bloc.getFoyer() == null) {
            if (foyer.getCapaciteFoyer() > 0) {
                bloc.setFoyer(foyer);
                foyer.setCapaciteFoyer(foyer.getCapaciteFoyer() - bloc.getCapaciteBloc());

                blocRepo.save(bloc);
                foyerRepo.save(foyer);
            } else {
                throw new CapaciteFoyerEpuiseeException();
            }

        } else {
            throw new BlocDejaReserveException();
        }
    }

}