package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Etudiant;

import java.util.List;

public interface IBloc {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc(Bloc bloc, long idBloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);
    void reserverChambreAvecMiseAJourCapacite(long idBloc, long idChambre, long idEtudiant);
    int trouverNombreReservationsParBloc(long idBloc);
    int countEtudiantsUniquesParBloc(long idBloc);
}