package tn.esprit.etude_de_cas.Service;


import tn.esprit.etude_de_cas.Entity.Chambre;

import java.util.List;
import java.util.Set;

public interface IChambre {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre chambre);

    Chambre updateChambre (Chambre chambre);

    Chambre retrieveChambre (long idChambre);
    Set<Chambre> findChambresByBlocIdBloc(Long idBloc);
}
