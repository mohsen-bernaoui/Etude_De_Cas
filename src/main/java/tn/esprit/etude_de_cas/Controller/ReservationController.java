package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Reservation;
import tn.esprit.etude_de_cas.Service.IReservation;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class ReservationController {
    private IReservation iReservation;
    @GetMapping("/retrieveAllReservation")
    public List<Reservation> retrieveAllReservation() {
        return iReservation.retrieveAllReservation();
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {return iReservation.updateReservation(reservation);}

   @GetMapping("/retrieveReservation/{idReservation}")
    public Reservation retrieveReservation(@PathVariable String idReservation) {return iReservation.retrieveReservation(idReservation);}

    @GetMapping("/findReservationsByEtudiantIdEtudiant/{idEtudiant}")
    public Set<Reservation> findReservationsByEtudiantIdEtudiant(@PathVariable long idEtudiant) {
        return iReservation.findReservationsByEtudiantsIdEtudiant(idEtudiant);
    }

}
