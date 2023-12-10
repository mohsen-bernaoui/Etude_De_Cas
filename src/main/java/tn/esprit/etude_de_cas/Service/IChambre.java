package tn.esprit.etude_de_cas.Service;


import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.TypeChambre;

import java.util.List;
import java.util.Set;

public interface IChambre {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre chambre);

    Chambre updateChambre (Chambre chambre);

    Chambre retrieveChambre (long idChambre);
    Set<Chambre> findChambresByBlocIdBloc(Long idBloc);

    void deleteChambre(long idChambre);

    Chambre affecterChambreABloc(long idChambre, long idBloc, String idReservation);
    Chambre affecterChambreAreservation(long idChambre, String idReservation);
    List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc);
    List<Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(TypeChambre typeChambre);
    List<TypeChambre> gettypechambre();
}
