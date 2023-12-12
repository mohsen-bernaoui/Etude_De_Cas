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

    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.bloc.idBloc = :idBloc")
    int countChambresByBlocId(long idBloc);
    @Query("SELECT DISTINCT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.capacity > 0")
    List<Chambre> findchambrebyTypechambre(@Param("idBloc") long idBloc);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.capacity > 0")
    List<Chambre> findByBloc_IdBlocAndTypeC(@Param("idBloc") Long idBloc);
    List<Chambre> findChambreByTypeC(TypeChambre typeChambre);
    @Query("SELECT c FROM Chambre c WHERE c.typeC = :typeChambre AND c.bloc.idBloc = :idBloc AND c.capacity > 0")
    List<Chambre> GetchambreByTypeChambreAndIdBloc(@Param("typeChambre") TypeChambre typeChambre, @Param("idBloc") long idBloc);
    Chambre findChambreByIdChambre(long idChambre);
    @Query("SELECT c FROM Chambre c WHERE c.typeC = :typeC AND c.capacity > 0")
    List <Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(@Param("typeC") TypeChambre typeChambre);


}
