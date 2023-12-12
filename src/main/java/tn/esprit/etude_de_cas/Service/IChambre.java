    package tn.esprit.etude_de_cas.Service;


    import tn.esprit.etude_de_cas.Entity.Chambre;
    import tn.esprit.etude_de_cas.Entity.TypeChambre;

    import java.util.List;
    import java.util.Set;

    public interface IChambre {
        List<Chambre> retrieveAllChambres();

        Chambre addChambre(Chambre chambre);

        Chambre updateChambre (Chambre chambre);

        Chambre retrieveChambre (long idChambre);
        Set<Chambre> findChambresByBlocIdBloc(Long idBloc);

        void deleteChambre(long idChambre);
        List<Chambre> findchambrebyTypechambre(long idbloc);
        List<Chambre> GetchambreByTypeChambre(TypeChambre typeChambre );
        List<Chambre> findChambreByTypeCAndIdBloc(TypeChambre typeChambre , Long idBloc );
         List<Chambre> findByTypeCWhereAndCapacityChambreGreaterThanZero(TypeChambre typeChambre);
        List<Chambre> findByBloc_IdBlocAndTypeC(Long idBloc) ;


    }
