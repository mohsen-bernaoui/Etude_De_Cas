package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Reposity.BlocRepo;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocServiceIMP implements IBloc{
    private BlocRepo blocRepo;
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


}