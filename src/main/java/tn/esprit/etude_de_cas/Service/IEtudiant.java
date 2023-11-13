package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.Etudiant;

import java.util.List;

public interface IEtudiant {
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public List<Etudiant> findallEtudiant();
    public Etudiant findById(long idE);
    public void deleteEtud(long idE);

}
