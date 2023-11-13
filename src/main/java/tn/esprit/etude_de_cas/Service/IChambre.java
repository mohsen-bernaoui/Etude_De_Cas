package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;

import java.util.List;

public interface IChambre {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre chambre);

    Chambre updateChambre (Chambre chambre);

    Chambre retrieveChambre (long idChambre);
}
