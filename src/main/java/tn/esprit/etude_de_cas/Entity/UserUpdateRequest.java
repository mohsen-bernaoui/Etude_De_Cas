package tn.esprit.etude_de_cas.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserUpdateRequest {
    public String name;
    public String email;
    public String password;
    public String roles;
    public String prenomEt;
    public long cin;
    public String ecole;
    public long dataNaissance;
    public String token;

    public User getUser() throws ParseException {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(roles);
        user.setPrenomEt(prenomEt);
        user.setCin(cin);
        user.setEcole(ecole);
        // convert timestamp to date
        Date date = new Date(dataNaissance);
        user.setDataNaissance(date);
        return user;
    }
}