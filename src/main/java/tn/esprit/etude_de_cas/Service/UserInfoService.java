package tn.esprit.etude_de_cas.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.User;
import tn.esprit.etude_de_cas.Reposity.UserInfoRepository;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    @Lazy
    private UserInfoRepository repository;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    public UserInfoService() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userDetail = repository.findByName(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserinfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public String addUser(User userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added Successfully";
    }

    public String editUser(User userInfo){
        repository.updateUser(userInfo);
        return "User Updated";
    }
}