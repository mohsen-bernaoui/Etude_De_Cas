package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Service.IChambre;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreController {
    private IChambre iChambre;
    @GetMapping("/retrieveAllChambres")
    public List<Chambre> retrieveAllChambres() {
        return iChambre.retrieveAllChambres();
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return iChambre.addChambre(chambre);
    }

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {return iChambre.updateChambre(chambre);}

    @PutMapping("/retrieveChambre/{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) {return iChambre.retrieveChambre(idChambre);}
    }
