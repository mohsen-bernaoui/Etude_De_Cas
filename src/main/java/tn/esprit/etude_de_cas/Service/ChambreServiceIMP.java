package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.Reservation;
import tn.esprit.etude_de_cas.Entity.TypeChambre;
import tn.esprit.etude_de_cas.Reposity.BlocRepo;
import tn.esprit.etude_de_cas.Reposity.ChambreRepo;
import tn.esprit.etude_de_cas.Reposity.ReservationRepo;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChambreServiceIMP implements IChambre{
    private ChambreRepo chambreRepo;
    private ReservationRepo reservationRepo;
    private BlocRepo blocRepo;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }
    @Override
    public Set<Chambre> findChambresByBlocIdBloc(Long idBloc) {
        return chambreRepo.findChambresByBlocIdBloc(idBloc);
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public Chambre affecterChambreABloc(long idChambre, long idBloc, String idReservation) {
        Chambre chambre=chambreRepo.findById(idChambre).orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
        if (chambre==null) {
            throw new RuntimeException("chambre non trouvé");
        }
        Bloc bloc=blocRepo.findByIdBloc(idBloc);
        chambre.setBloc(bloc);
        List<Reservation> reservation=reservationRepo.findByIdReservation(idReservation);
        chambre.setReservations(reservation);
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre affecterChambreAreservation(long idChambre, String idReservation) {
        Chambre chambre=chambreRepo.findById(idChambre).orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
        if (chambre==null) {
            throw new RuntimeException("chambre non trouvé");
        }
        List<Reservation> reservation=reservationRepo.findByIdReservation(idReservation);
        chambre.setReservations(reservation);
        return chambreRepo.save(chambre);
    }

    @Override
    public List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc) {
        return chambreRepo.findByBloc_IdBlocAndTypeC(idBloc);
    }

    @Override
    public List<Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(TypeChambre typeChambre) {
        return chambreRepo.findByTypeCWhereAndCapacityChambreGreaterThanZero(typeChambre);
    }

    @Override
    public List<TypeChambre> gettypechambre() {
        return chambreRepo.getAllByTypeC();
    }

}
