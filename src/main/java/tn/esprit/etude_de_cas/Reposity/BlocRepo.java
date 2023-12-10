package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Bloc;

import java.util.List;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {
    @Query("SELECT COUNT(r) " +
            "FROM Bloc b " +
            "LEFT JOIN b.chambres c " +
            "LEFT JOIN c.reservations r " +
            "WHERE b.idBloc = :idBloc")
    int trouverNombreReservationsParBloc(@Param("idBloc") long idBloc);
    @Query("SELECT COUNT(DISTINCT e.idEtudiant) " +
            "FROM Bloc b " +
            "LEFT JOIN b.chambres c " +
            "LEFT JOIN c.reservations r " +
            "LEFT JOIN r.etudiants e " +
            "WHERE b.idBloc = :idBloc")
    int countEtudiantsUniquesParBloc(@Param("idBloc") long idBloc);
}
