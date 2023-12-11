package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.Chambre;

import java.util.Set;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {
    Set<Chambre> findChambresByBlocIdBloc(Long idBloc);

    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.bloc.idBloc = :idBloc")
    int countChambresByBlocId(long idBloc);

}
