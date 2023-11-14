package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Reservation;

import java.util.Set;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,String> {
    Set<Reservation> findReservationsByEtudiantsIdEtudiant(long idEtudiant);
}
