package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Reservation;

import java.util.List;
import java.util.Set;

public interface IReservation {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation reservation);

    Reservation retrieveReservation (String idReservation);

    Set<Reservation> findReservationsByEtudiantsIdEtudiant(long idEtudiant);
    Set<Reservation> findReservationsByEtudiantsNomEt(String nomEt);

    Set<Reservation> findReservationsByEtudiantsNomStartsWithAB();
    Reservation addReservation(Reservation reservation);
    Reservation deleteReservation (String idReservation);
    Reservation postReservationWithIdEtudiantAndIdChambre(Reservation reservation, int idEtudiant, int idChambre);
    Reservation updateReservationById(Reservation reservation, String idReservation);
}
