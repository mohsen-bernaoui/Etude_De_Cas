package tn.esprit.etude_de_cas.Service;

import tn.esprit.etude_de_cas.Entity.User;

import java.util.List;

public interface IEtudiant {
    public User addEtudiant(User e);
    public User updateEtudiant(User e);
    public List<User> findallEtudiant();
    public User findById(long idE);
    public void deleteEtud(long idE);

}
