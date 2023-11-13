package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Reservation;

import java.util.List;

public interface IReservation {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation reservation);

    Reservation retrieveReservation (String idReservation);
}
