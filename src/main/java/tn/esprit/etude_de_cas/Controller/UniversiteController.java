package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Entity.University;
import tn.esprit.etude_de_cas.Service.FoyerServiceIMP;

import tn.esprit.etude_de_cas.Service.UniversiteServiceIMP;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {
    private UniversiteServiceIMP universiteServiceIMP;
    private FoyerServiceIMP foyerServiceIMP;
    @GetMapping("/retrieveAllUniversities")
    public List<University> retrieveAllUniversities() {
        return universiteServiceIMP.retrieveAllUniversities();
    }

    @PostMapping("/addUniversite")
    public University addUniversite(@RequestBody University university) {return universiteServiceIMP.addUniversite(university);}

    @PutMapping("/updateUniversite")
    public University updateUniversite(@RequestBody University university) {return universiteServiceIMP.updateUniversite(university);}

    @GetMapping("/retrieveUniversite/{idUniversite}")
    public University retrieveUniversite(@PathVariable long idUniversite) {return universiteServiceIMP.retrieveUniversite(idUniversite);}
    @PostMapping("/addUniversityAndAssignToFoyer/{foyerId}")
    public University addUniversityAndAssignToFoyer(@RequestBody University university, @PathVariable long foyerId) {
        Foyer foyer = foyerServiceIMP.findById(foyerId);
        return universiteServiceIMP.addUniversityAndAssignToFoyer(university, foyer);
    }
    @GetMapping("/getUniversiteIdFromFoyerTable/{idFoyer}")
    public University getUniversiteIdFromFoyerTable(@PathVariable long idFoyer) {
        return universiteServiceIMP.getUniversiteIdFromFoyerTable(idFoyer);
    }
    @PostMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniv}")
    public University affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniv) {
        return universiteServiceIMP.affecterFoyerAUniversite(idFoyer, nomUniv);
    }

}
