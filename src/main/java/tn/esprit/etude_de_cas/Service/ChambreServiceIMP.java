    package tn.esprit.etude_de_cas.Service;
    import lombok.AllArgsConstructor;
    import org.springframework.stereotype.Service;
    import tn.esprit.etude_de_cas.Entity.Chambre;
    import tn.esprit.etude_de_cas.Entity.Reservation;
    import tn.esprit.etude_de_cas.Entity.TypeChambre;
    import tn.esprit.etude_de_cas.Entity.User;
    import tn.esprit.etude_de_cas.Reposity.ChambreRepo;
    import tn.esprit.etude_de_cas.Reposity.EtudtiantRepo;
    import tn.esprit.etude_de_cas.Reposity.ReservationRepo;

    import java.time.LocalDateTime;
    import java.util.*;
    import java.util.stream.Collectors;

    @Service
    @AllArgsConstructor
    public class ChambreServiceIMP implements IChambre{
        private ChambreRepo chambreRepo;
        private ReservationRepo reservationRepo;
        private EtudtiantRepo etudtiantRepo;
        @Override
        public List<Chambre> retrieveAllChambres() {
            return chambreRepo.findAll();
        }

        @Override
        public Chambre addChambre(Chambre chambre) {
            chambre.setLastCleaningDate(LocalDateTime.now());
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
        public List<Chambre> findchambrebyTypechambre(long idbloc) {
            return chambreRepo.findchambrebyTypechambre(idbloc);
        }

        @Override
        public List<Chambre> GetchambreByTypeChambre(TypeChambre typeChambre) {
            return chambreRepo.findChambreByTypeC(typeChambre);
        }

        @Override
        public List<Chambre> findChambreByTypeCAndIdBloc(TypeChambre typeChambre, Long idBloc) {

            return chambreRepo.GetchambreByTypeChambreAndIdBloc(typeChambre, idBloc);
        }

        @Override
        public List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc) {
            return chambreRepo.findByBloc_IdBlocAndTypeC(idBloc);
        }
        @Override
        public List<Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(TypeChambre typeChambre) {
            return chambreRepo.findByTypeCWhereAndCapacityChambreGreaterThanZero(typeChambre);
        }

    }
