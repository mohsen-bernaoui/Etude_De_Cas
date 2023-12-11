package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Foyer;

import java.util.List;

public interface IFoyer {
    public Foyer addFoyer(Foyer f);
    public Foyer updateFoyer(Foyer foyer, long idfFoyer);
    public List<Foyer> findallFoyer();
    public Foyer findById(long idF);
    public void deleteFoyer(long idF);
    public Foyer affecterFoyerAUniversite(long idFoyer, String nomUniv);

    public List<Foyer> getFoyerNotAffected();
    public List<Foyer> getAllFoyersWithBloc();



}
