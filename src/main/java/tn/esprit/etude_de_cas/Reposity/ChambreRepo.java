package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Entity.TypeChambre;

import java.util.List;
import java.util.Set;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {
    Set<Chambre> findChambresByBlocIdBloc(Long idBloc);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findByBloc_IdBlocAndTypeC(@Param("idBloc") Long idBloc, @Param("typeC") TypeChambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.typeC = :typeC AND c.capacityChambre > 0")
    List <Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(@Param("typeC") TypeChambre typeChambre);
}
