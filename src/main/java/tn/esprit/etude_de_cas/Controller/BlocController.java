package tn.esprit.etude_de_cas.Controller;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Service.IBloc;

import java.util.List;
import java.util.Set;

//les exceptions
import tn.esprit.etude_de_cas.Exceptions.BlocDejaReserveException;
import tn.esprit.etude_de_cas.Exceptions.BlocNotFoundException;
import tn.esprit.etude_de_cas.Exceptions.CapaciteFoyerEpuiseeException;
import tn.esprit.etude_de_cas.Exceptions.FoyerNotFoundException;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BlocController {
        private IBloc iBloc;

        @GetMapping("/retrieveBlocs")
        public List<Bloc> retrieveBlocs() {
                return iBloc.retrieveBlocs();
        }

        @PutMapping("/updateBloc/{idBloc}")
        public ResponseEntity<Bloc> updateBloc(@RequestBody Bloc updatedBloc, @PathVariable long idBloc) {
                Bloc existingBloc = iBloc.retrieveBloc(idBloc);
                if (existingBloc != null) {
                        existingBloc.setNomBloc(updatedBloc.getNomBloc());
                        existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());
                        Bloc updatedBlocResult = iBloc.updateBloc(existingBloc, idBloc);
                        return ResponseEntity.ok(updatedBlocResult);
                } else {
                        return ResponseEntity.notFound().build();
                }
        }

        @PostMapping("/addBloc")
        public Bloc addBloc(@RequestBody Bloc bloc) {
                return iBloc.addBloc(bloc);
        }

        @GetMapping("/retrieveBloc/{idBloc}")
        public Bloc retrieveBloc(@PathVariable long idBloc) {
                return iBloc.retrieveBloc(idBloc);
        }

        @DeleteMapping("/removeBloc/{idBloc}")
        public void removeBloc(@PathVariable long idBloc) {
                iBloc.removeBloc(idBloc);
        }

        @GetMapping("/findBlocByTypeC/{typC}")
        public Set<Bloc> findBlocByTypeC(@PathVariable TypeChambre typC) {
                return iBloc.findBlocByChambresType(typC);
        }

        @GetMapping("/findBlocBychambres/{idChambre}")
        public Bloc findBlocByChambres(@PathVariable long idChambre) {
                return iBloc.findBlocByChambresIdChambre(idChambre);
        }

        @GetMapping("/findById/{idBloc}")
        public Bloc findBlocById(@PathVariable long idBloc) {
                return iBloc.findBlocById(idBloc);
        }

        @GetMapping("/trouverNombreReservationsParBloc/{idBloc}")
        public int trouverNombreReservationsParBloc(@PathVariable long idBloc) {
                return iBloc.trouverNombreReservationsParBloc(idBloc);
        }

        @GetMapping("/compterChambresParBloc/{idBloc}")
        public int compterChambresParBloc(@PathVariable long idBloc) {
                return iBloc.compterChambresParBloc(idBloc);
        }


        @PostMapping("/{idBloc}/assign/{idfFoyer}")
        public ResponseEntity<String> assignBlocToFoyer(@PathVariable Long idBloc, @PathVariable Long idfFoyer) {
                try {
                        iBloc.assignBlocToFoyer(idfFoyer, idBloc);
                        return new ResponseEntity<>("Bloc assigned to foyer successfully", HttpStatus.OK);
                } catch (FoyerNotFoundException | BlocNotFoundException e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
                } catch (CapaciteFoyerEpuiseeException e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
                } catch (BlocDejaReserveException e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
                }
@GetMapping("/findidBlocByfoyerId/{idFoyer}")
public List<Bloc> findidBlocByfoyerId(@PathVariable long idFoyer){
        return iBloc.findidBlocByfoyerId(idFoyer);}
        @GetMapping("/findByFoyer/{idFoyer}")
        public List<Bloc> findByFoyer(@PathVariable long idFoyer){
                return iBloc.findByFoyerIdfFoyer(idFoyer);
        }
        }
}
