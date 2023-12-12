package tn.esprit.etude_de_cas.Service;

import org.springframework.data.repository.query.Param;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.TypeChambre;


import java.util.List;
import java.util.Set;

public interface IBloc {
    List<Bloc> retrieveBlocs();

    public Bloc updateBloc(Bloc bloc, long idBloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);
    Set<Bloc> findBlocByChambresType(TypeChambre typeC);

    Bloc findBlocByChambresIdChambre(long idChambre);

    Bloc findBlocById(long idBloc);

    int trouverNombreReservationsParBloc(long idBloc);
    int compterChambresParBloc(long idBloc);

    List<Bloc> findidBlocByfoyerId(long idFoyer);
    List<Bloc> findByFoyerIdfFoyer(long idFoyer)    ;

    //service avance
    public void assignBlocToFoyer(Long idfFoyer, Long idBloc);

}