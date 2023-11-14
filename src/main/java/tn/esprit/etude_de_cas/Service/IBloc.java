package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.TypeChambre;


import java.util.List;
import java.util.Set;

public interface IBloc {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);
    Set<Bloc> findBlocByChambresType(TypeChambre typeC);
}