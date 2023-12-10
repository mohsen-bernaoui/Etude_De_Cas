package tn.esprit.etude_de_cas.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Reposity.UserRepo;

import java.util.Optional;

//make the function to get the user by id, and the function to get all users
//make the function to add a user
//make the function to update a user
//make the function to delete a user
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User getUserByName(String name) {
        return userRepo.findByName(name);
    }
    

    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User createUser(User user) {
        if(userRepo.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        User existingUser = userRepo.findById(user.getId()).get();
        existingUser.setEmail(null != user.getEmail() ? user.getEmail() : existingUser.getEmail());
        Optional<Long> cin = Optional.of(user.getCin());
        existingUser.setCin(cin.isPresent() ? user.getCin() : existingUser.getCin());
        existingUser.setName(null != user.getName() ? user.getName() : existingUser.getName());
        existingUser.setPrenomEt(null != user.getPrenomEt() ? user.getPrenomEt() : existingUser.getPrenomEt());
        existingUser.setRoles(null != user.getRoles() ? user.getRoles() : existingUser.getRoles());
        existingUser.setEcole(null != user.getEcole() ? user.getEcole() : existingUser.getEcole());
        existingUser.setDataNaissance(null != user.getDataNaissance() ? user.getDataNaissance() : existingUser.getDataNaissance());
        existingUser.setPassword(null != user.getPassword() ? encoder.encode(user.getPassword()) : existingUser.getPassword());
        return userRepo.save(existingUser);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }



}