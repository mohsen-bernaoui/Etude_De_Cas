package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.University;

import java.util.List;

public interface IUniversite {
    List<University> retrieveAllUniversities();
    University addUniversite (University university);
    University updateUniversite (University university);
    University retrieveUniversite (long idUniversite);
    public void deleteUniversite(long iduniveriste) ;
}