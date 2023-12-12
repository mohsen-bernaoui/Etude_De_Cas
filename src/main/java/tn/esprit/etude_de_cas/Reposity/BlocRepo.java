package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Bloc;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.TypeChambre;

import java.util.List;
import java.util.Set;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {
    Set<Bloc> findBlocByChambresTypeC(TypeChambre typeC);
    Bloc findBlocByChambresIdChambre(long idChambre);


    @Query("SELECT COUNT(r) " +
            "FROM Bloc b " +
            "LEFT JOIN b.chambres c " +
            "LEFT JOIN c.reservations r " +
            "WHERE b.idBloc = :idBloc")
    int trouverNombreReservationsParBloc(@Param("idBloc") long idBloc);
    List<Bloc> findByFoyerIdfFoyer(long idFoyer);
}
