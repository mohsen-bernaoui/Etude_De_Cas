package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Etudiant;
import tn.esprit.etude_de_cas.Service.IEtudiant;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {
    private IEtudiant iEtudiant;
    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){return iEtudiant.addEtudiant(e);}
    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){return iEtudiant.updateEtudiant(e);}
    @GetMapping("/getAll")
    public List<Etudiant> findallEtudiant(){return iEtudiant.findallEtudiant();}
    @GetMapping("/getEtudiant/{idE}")
    public Etudiant findById(@PathVariable long idE){
        return iEtudiant.findById(idE);
    }
    @DeleteMapping("/deleteEtudiant/{idE}")
    public void deleteEtud(@PathVariable long idE){
        iEtudiant.deleteEtud(idE);
    }
}
