package tn.esprit.etude_de_cas.Reposity;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.etude_de_cas.Entity.User;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);

    default void updateUser(User updatedUser) {
        findById(updatedUser.getId()).ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setCin(updatedUser.getCin());
            user.setEcole(updatedUser.getEcole());
            user.setDataNaissance(updatedUser.getDataNaissance());
            user.setPrenomEt(updatedUser.getPrenomEt());
            // Save the updated user
            save(user);
        });
    }
    




}