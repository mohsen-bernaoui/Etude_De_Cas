package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Service.IEtudiant;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {
    private IEtudiant iEtudiant;
    @PostMapping("/addEtudiant")
    public User addEtudiant(@RequestBody User e){return iEtudiant.addEtudiant(e);}
    @PutMapping("/updateEtudiant")
    public User updateEtudiant(@RequestBody User e){return iEtudiant.updateEtudiant(e);}
    @GetMapping("/getAll")
    public List<User> findallEtudiant(){return iEtudiant.findallEtudiant();}
    @GetMapping("/getEtudiant/{idE}")
    public User findById(@PathVariable long idE){
        return iEtudiant.findById(idE);
    }
    @DeleteMapping("/deleteEtudiant/{idE}")
    public void deleteEtud(@PathVariable long idE){
        iEtudiant.deleteEtud(idE);
    }
}
