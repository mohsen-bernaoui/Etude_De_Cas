package tn.esprit.etude_de_cas.Reposity;

import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Reservation;

import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,String> {
    Set<Reservation> findReservationsByEtudiantsIdEtudiant(long idEtudiant);
    Set<Reservation> findReservationsByEtudiantsNomEt(String nomEt);

    List<Reservation> findByIdReservation(String idReservation);


    @Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.nomEt LIKE 'AB%'")
    Set<Reservation> findReservationsByEtudiantsNomStartsWithAB();

    //@Query("SELECT r FROM Reservation r JOIN r.chambre c WHERE c.idChambre = :idChambre AND r.etudiants.idEtudiant = :idEtudiant")
    //Reservation findReservationByChambreAndEtudiant(@Param("idChambre") long idChambre, @Param("idEtudiant") long idEtudiant);

    //Reservation findByChambreIdChambreAndEtudiantsIdEtudiant(long idChambre, long idEtudiant);

}
