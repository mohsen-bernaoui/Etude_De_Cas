package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.University;
import tn.esprit.etude_de_cas.Service.IUniversite;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {
    private IUniversite iUniversite;
    @GetMapping("/retrieveAllUniversities")
    public List<University> retrieveAllUniversities() {
        return iUniversite.retrieveAllUniversities();
    }

    @PostMapping("/addUniversite")
    public University addUniversite(@RequestBody University university) {return iUniversite.addUniversite(university);}

    @PutMapping("/updateUniversite")
    public University updateUniversite(@RequestBody University university) {return iUniversite.updateUniversite(university);}

    @GetMapping("/retrieveUniversite/{idUniversite}")
    public University retrieveUniversite(@PathVariable long idUniversite) {return iUniversite.retrieveUniversite(idUniversite);}
}
