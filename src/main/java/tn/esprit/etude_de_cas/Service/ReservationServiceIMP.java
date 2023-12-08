package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.*;
import tn.esprit.etude_de_cas.Reposity.*;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationServiceIMP implements IReservation{
    private ReservationRepo reservationRepo;
    private EtudtiantRepo etudtiantRepo;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public Set<Reservation> findReservationsByEtudiantsIdEtudiant(long idEtudiant) {
        return reservationRepo.findReservationsByEtudiantsId(idEtudiant);
    }

    @Override
    public Set<Reservation> findReservationsByEtudiantsNomEt(String nomEt) {
        return reservationRepo.findReservationsByEtudiantsName(nomEt);
    }

    @Override
    public Set<Reservation> findReservationsByEtudiantsNomStartsWithAB() {
        return reservationRepo.findReservationsByEtudiantsNomStartsWithAB();
    }

    @Override
    public void deleteReservation(String ID_reservation) {
        reservationRepo.deleteById(ID_reservation);
    }

    @Override
    public Reservation affecterReservationAEtudiant(String idReservation,long idEtudiant) {
        Reservation reservation = reservationRepo.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Reservation non trouvée"));

        List<Etudiant>etudiant = etudtiantRepo.findByIdEtudiant(idEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Etudiant non trouvé");
        }
        reservation.setEtudiants(etudiant);
        return reservationRepo.save(reservation);
    }

}
