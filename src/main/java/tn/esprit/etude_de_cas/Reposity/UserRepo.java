package tn.esprit.etude_de_cas.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByEmail(String email);

    User findByName(String name);
}
