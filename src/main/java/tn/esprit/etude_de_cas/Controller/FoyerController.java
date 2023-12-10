package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Service.FoyerServiceIMP;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class FoyerController {
    @Autowired
    private FoyerServiceIMP foyerServiceImp;
    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServiceImp.addFoyer(f);
    }
    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerServiceImp.updateFoyer(f);
    }
    @GetMapping("/getAllf")
    public List<Foyer> findAllFoyer(){
        return foyerServiceImp.findallFoyer();
    }
        @GetMapping("/getFoyer/{idF}")
    public Foyer findById(@PathVariable long idF){
        return foyerServiceImp.findById(idF);
    }
    @DeleteMapping("/deleteFoyer/{idF}")
    public void deleteFoyer(@PathVariable long idF){
        foyerServiceImp.deleteFoyer(idF);
    }
    @PostMapping("/affecter/{idFoyer}/{nomUniv}")
    public Foyer affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniv) {

        return foyerServiceImp.affecterFoyerAUniversite(idFoyer, nomUniv);
    }
    @GetMapping("/getFoyer/{idUniversite}")
    public Foyer getFoyerIdFromUniversityTable(@PathVariable long idUniversite) {
        return foyerServiceImp.getFoyerIdFromUniversityTable(idUniversite);
    }
    @GetMapping("/getFoyersWithCapacity/{universiteNom}")
    public List<Foyer> getFoyersWithCapacity(@PathVariable String universiteNom) {
        return foyerServiceImp.getFoyersWithCapacity(universiteNom);
    }
}
