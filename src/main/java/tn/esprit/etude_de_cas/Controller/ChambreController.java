package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Service.IChambre;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/findChambresByBlocIdBloc/{idBloc}")
    public Set<Chambre> findChambresByBlocIdBloc(@PathVariable Long idBloc) {
        return iChambre.findChambresByBlocIdBloc(idBloc);
    }

    @DeleteMapping("/deleteChambre/{idChambre}")
    public void deleteChambre(@PathVariable long idChambre) {
        iChambre.deleteChambre(idChambre);}

    @GetMapping("/findchambrebyTypechambre/{idbloc}")
    public List<Chambre> findchambrebyTypechambre(@PathVariable long idbloc) {
        return iChambre.findchambrebyTypechambre(idbloc);
    }

    @GetMapping("/GetchambreByTypeChambre/{typeChambre}")
    public List<Chambre> GetchambreByTypeChambre(@PathVariable TypeChambre typeChambre) {
        return iChambre.GetchambreByTypeChambre(typeChambre);

    }
    @GetMapping("/findByBloc_IdBlocAndTypeC/{idBloc}")
    public List<Chambre> findByBloc_IdBlocAndTypeC(@PathVariable Long idBloc) {
        return iChambre.findByBloc_IdBlocAndTypeC(idBloc);
    }

    @GetMapping("/findChambreByTypeCAndIdBloc/{typeChambre}/{idBloc}")
    public List<Chambre> findChambreByTypeCAndIdBloc(@PathVariable TypeChambre typeChambre, @PathVariable Long idBloc) {
        return iChambre.findChambreByTypeCAndIdBloc(typeChambre, idBloc);
    }
    @GetMapping("/findByTypeCWhereAndCapacityChambreGreaterThanZero/{typeChambre}")
    public List<Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(@PathVariable TypeChambre typeChambre) {
        return iChambre.findByTypeCWhereAndCapacityChambreGreaterThanZero(typeChambre);
    }
    
}
