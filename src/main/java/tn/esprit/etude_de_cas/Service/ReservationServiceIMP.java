package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Reservation;
import tn.esprit.etude_de_cas.Reposity.ReservationRepo;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServiceIMP implements IReservation{
    private ReservationRepo reservationRepo;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public Set<Reservation> findReservationsByEtudiantsIdEtudiant(long idEtudiant) {
        return reservationRepo.findReservationsByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public Set<Reservation> findReservationsByEtudiantsNomEt(String nomEt) {
        return reservationRepo.findReservationsByEtudiantsNomEt(nomEt);
    }

}
