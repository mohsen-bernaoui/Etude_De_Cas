    package tn.esprit.etude_de_cas.Service;

    import lombok.AllArgsConstructor;
    import org.springframework.stereotype.Service;
    import tn.esprit.etude_de_cas.Entity.Chambre;
    import tn.esprit.etude_de_cas.Entity.Reservation;
    import tn.esprit.etude_de_cas.Entity.User;
    import tn.esprit.etude_de_cas.Reposity.ChambreRepo;
    import tn.esprit.etude_de_cas.Reposity.EtudtiantRepo;
    import tn.esprit.etude_de_cas.Reposity.ReservationRepo;

    import java.util.List;
    import java.util.Set;

    @Service
    @AllArgsConstructor
    public class ReservationServiceIMP implements IReservation{
        private ReservationRepo reservationRepo;
        private ChambreRepo chambreRepo;
        private EtudtiantRepo etudtiantRepo;
        @Override
        public List<Reservation> retrieveAllReservation() {
            return reservationRepo.findAll();
        }

        @Override
        public Reservation updateReservation(Reservation reservation) {
            return reservationRepo.save(reservation);
        }

        @Override
        public Reservation retrieveReservation(String idReservation) {
            return reservationRepo.findById(idReservation).orElse(null);
        }

        @Override
        public Set<Reservation> findReservationsByEtudiantsIdEtudiant(long idEtudiant) {
            return reservationRepo.findReservationsByEtudiantsId(idEtudiant);
        }

        @Override
        public Set<Reservation> findReservationsByEtudiantsNomEt(String nomEt) {
            return reservationRepo.findReservationsByEtudiantsName(nomEt);
        }

        @Override
        public Set<Reservation> findReservationsByEtudiantsNomStartsWithAB() {
            return reservationRepo.findReservationsByEtudiantsNomStartsWithAB();
        }

        @Override
        public Reservation addReservation(Reservation reservation) {

            return reservationRepo.save(reservation);
        }

        @Override
        public Reservation deleteReservation(String idReservation) {

            Reservation reservation1 = reservationRepo.findById(idReservation).orElse(null);
            if (reservation1 == null) {
                return null;
            }
            reservationRepo.deleteById(idReservation);
            return reservation1;
        }

        @Override
        public Reservation postReservationWithIdEtudiantAndIdChambre(Reservation reservation, int idEtudiant,int idChambre) {

            Chambre chambre = chambreRepo.findChambreByIdChambre(idChambre);
            reservation.setChambre(chambre);
            List<User> etudtiant=etudtiantRepo.findUserById(idEtudiant);
            reservation.setEtudiants(etudtiant);
            return reservationRepo.save(reservation);
        }

        @Override
        public Reservation updateReservationById(Reservation reservation, String idReservation) {

            Reservation reservation1 = reservationRepo.findById(idReservation).orElse(null);
            if (reservation1 == null) {
                return null;
            }
            reservation.setIdReservation(idReservation);
            return reservationRepo.save(reservation);
        }

    }
