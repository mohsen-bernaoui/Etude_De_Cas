package tn.esprit.etude_de_cas.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Service.BlocServiceIMP;
import tn.esprit.etude_de_cas.Service.IBloc;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlocController {
private IBloc iBloc;

    @GetMapping("/retrieveBlocs")
    public List<Bloc> retrieveBlocs() {return iBloc.retrieveBlocs();}

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return iBloc.updateBloc(bloc);
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
}
