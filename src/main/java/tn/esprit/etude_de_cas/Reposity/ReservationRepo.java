    package tn.esprit.etude_de_cas.Reposity;

    import jakarta.persistence.criteria.From;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;
    import tn.esprit.etude_de_cas.Entity.Chambre;
    import tn.esprit.etude_de_cas.Entity.Reservation;

    import java.util.List;
    import java.util.Set;

    @Repository
    public interface ReservationRepo extends JpaRepository<Reservation,String> {
        Set<Reservation> findReservationsByEtudiantsId(long idEtudiant);
        Set<Reservation> findReservationsByEtudiantsName(String nomEt);

        @Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.name LIKE 'AB%'")
        Set<Reservation> findReservationsByEtudiantsNomStartsWithAB();

        List<Reservation> findByIdReservation(String idReservation);
    }
