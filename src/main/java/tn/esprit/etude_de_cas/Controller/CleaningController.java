package tn.esprit.etude_de_cas.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Reposity.ChambreRepo;
import tn.esprit.etude_de_cas.Service.CleaningServiceIMP;

@RestController
@RequestMapping("/cleaning")
@CrossOrigin(origins = "http://localhost:4200")
public class CleaningController {
    private final ChambreRepo chambreRepo;
    private final CleaningServiceIMP cleaningServiceIMP;

    @Autowired
    public CleaningController(ChambreRepo chambreRepo, CleaningServiceIMP cleaningServiceIMP) {
        this.chambreRepo = chambreRepo;
        this.cleaningServiceIMP = cleaningServiceIMP;
    }
    @PostMapping("/schedule/{idChambre}")
    public ResponseEntity<String> scheduleCleaning(@PathVariable Long idChambre){
        Chambre chambre = chambreRepo.findById(idChambre).orElse(null);
        if (chambre == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with id " + idChambre + " not found.");
        }
        cleaningServiceIMP.scheduleCleaning(chambre);
        return ResponseEntity.status(HttpStatus.OK).body("Cleaning scheduled for room " + idChambre);
    }
    @PostMapping("/mark-cleaned/{idChambre}")
    public ResponseEntity<String> markRoomAsCleaned(@PathVariable Long idChambre) {
        Chambre chambre = chambreRepo.findById(idChambre).orElse(null);
        if (chambre == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room with id " + idChambre + " not found.");
        }
        cleaningServiceIMP.markRoomAsCleaned(chambre);
        return ResponseEntity.status(HttpStatus.OK).body("Room " + idChambre + " marked as cleaned");
    }

}
