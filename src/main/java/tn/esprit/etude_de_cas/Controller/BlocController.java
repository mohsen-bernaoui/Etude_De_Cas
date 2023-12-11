package tn.esprit.etude_de_cas.Controller;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Service.IBloc;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BlocController{
private IBloc iBloc;

@GetMapping("/retrieveBlocs")
public List<Bloc> retrieveBlocs(){return iBloc.retrieveBlocs();}

@PutMapping("/updateBloc/{idBloc}")
public ResponseEntity<Bloc> updateBloc(@RequestBody Bloc updatedBloc,@PathVariable long idBloc){
        Bloc existingBloc=iBloc.retrieveBloc(idBloc);
        if(existingBloc!=null){
        existingBloc.setNomBloc(updatedBloc.getNomBloc());
        existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());
        Bloc updatedBlocResult=iBloc.updateBloc(existingBloc,idBloc);
        return ResponseEntity.ok(updatedBlocResult);
        }else{
        return ResponseEntity.notFound().build();
        }
        }

@PostMapping("/addBloc")
public Bloc addBloc(@RequestBody Bloc bloc){
        return iBloc.addBloc(bloc);
        }

@GetMapping("/retrieveBloc/{idBloc}")
public Bloc retrieveBloc(@PathVariable long idBloc){
        return iBloc.retrieveBloc(idBloc);
        }

@DeleteMapping("/removeBloc/{idBloc}")
public void removeBloc(@PathVariable long idBloc){
        iBloc.removeBloc(idBloc);
        }

@GetMapping("/findBlocByTypeC/{typC}")
public Set<Bloc> findBlocByTypeC(@PathVariable TypeChambre typC){
        return iBloc.findBlocByChambresType(typC);
        }
@GetMapping("/findBlocBychambres/{idChambre}")
public Bloc findBlocByChambres(@PathVariable long idChambre){
        return iBloc.findBlocByChambresIdChambre(idChambre);
        }
@GetMapping("/findById/{idBloc}")
public Bloc findBlocById(@PathVariable long idBloc){
        return iBloc.findBlocById(idBloc);
        }

@GetMapping("/trouverNombreReservationsParBloc/{idBloc}")
public int trouverNombreReservationsParBloc(@PathVariable long idBloc){
        return iBloc.trouverNombreReservationsParBloc(idBloc);
        }
@GetMapping("/compterChambresParBloc/{idBloc}")
public int compterChambresParBloc(@PathVariable long idBloc){
        return iBloc.compterChambresParBloc(idBloc);
        }

        }
