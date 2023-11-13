package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Foyer;
import tn.esprit.etude_de_cas.Service.FoyerServiceIMP;

import java.util.List;

@RestController
@AllArgsConstructor
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
}
