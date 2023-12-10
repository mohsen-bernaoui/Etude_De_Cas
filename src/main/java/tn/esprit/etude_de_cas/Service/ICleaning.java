package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Chambre;

import java.util.List;

public interface ICleaning {
    void scheduleCleaning(Chambre chambre);
    void markRoomAsCleaned(Chambre chambre);
}
