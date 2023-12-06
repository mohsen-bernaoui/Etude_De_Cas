package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Reposity.BlocRepo;
import tn.esprit.etude_de_cas.Reposity.FoyerRepo;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocServiceIMP implements IBloc{
    private BlocRepo blocRepo;
    private FoyerRepo foyerRepo;
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
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
    public Bloc affecterFoyerABloc(long idFoyer, long idBloc) {

        Bloc bloc = blocRepo.findById(idBloc).orElse(null);
        if (bloc == null) {
            throw new RuntimeException("Bloc non trouvé");
        }
        Foyer foyer =foyerRepo.findByIdfFoyer(idFoyer);
        bloc.setFoyer(foyer);
        return blocRepo.save(bloc);
    }

    @Override
    public List<Bloc> findByFoyerIdfFoyer(long idFoyer) {
        return blocRepo.findByFoyerIdfFoyer(idFoyer);
    }

}