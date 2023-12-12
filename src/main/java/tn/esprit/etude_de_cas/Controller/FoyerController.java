package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Bloc;
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
    @PutMapping("/updateFoyer/{idfFoyer}")
    public ResponseEntity<Foyer> updateFoyer(@RequestBody Foyer updatedFoyer, @PathVariable long idfFoyer){
        Foyer existingFoyer=foyerServiceImp.findById(idfFoyer);
        if(existingFoyer!=null){
            existingFoyer.setNomFoyer(updatedFoyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(updatedFoyer.getCapaciteFoyer());
            Foyer updatedFoyerResult=foyerServiceImp.updateFoyer(existingFoyer,idfFoyer);
            return ResponseEntity.ok(updatedFoyerResult);
        }else{
            return ResponseEntity.notFound().build();
        }
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
   /* @PostMapping("/affecter/{idFoyer}/{nomUniversite}")
    public ResponseEntity<String> affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniv) {
        foyerServiceImp.affecterFoyerAUniversite(idFoyer, nomUniv);return ResponseEntity.ok("Foyer affecté à l'université avec succès");}*/
   @PostMapping("/affecter/{idFoyer}/{nomUniversite}")
   public ResponseEntity<String> affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
       Foyer foyer = foyerServiceImp.affecterFoyerAUniversite(idFoyer, nomUniversite);
       return ResponseEntity.ok("Foyer affecté à l'université avec succès");
   }

    @GetMapping("/getfoyernotaffected")
    public List<Foyer> getFoyerNotAffected(){
        return foyerServiceImp.getFoyerNotAffected();
    }

    @GetMapping("/getFoyerByUniversityId/{idUniversity}")
    public Foyer findFoyerByUniversityId(@PathVariable long idUniversity) {
        return foyerServiceImp.findFoyerByUniversityId(idUniversity);
    }
    @GetMapping("/getFoyersWithCapacity/{universiteNom}")
    public List<Foyer> getFoyersWithCapacity(@PathVariable String universiteNom) {
        return foyerServiceImp.getFoyersWithCapacity(universiteNom);
    }

    @GetMapping("/foyers-with-bloc")
    public ResponseEntity<List<Foyer>> getAllFoyersWithBloc(){
        try {
            List<Foyer> foyersWithBloc= foyerServiceImp.getAllFoyersWithBloc();
            return new ResponseEntity<>(foyersWithBloc, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
