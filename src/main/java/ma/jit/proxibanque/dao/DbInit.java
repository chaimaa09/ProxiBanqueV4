package ma.jit.proxibanque.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.entities.Conseiller;
import ma.jit.proxibanque.entities.Employe;
import ma.jit.proxibanque.entities.User;


@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
       this.userRepository.deleteAll();

        // Create users
        User dan = new User("nabila",passwordEncoder.encode("nabila123"),"Moderateur","");
        User admin = new User("chaimaa",passwordEncoder.encode("chaimaa123"),"CONSEILLER","");
        User manager = new User("fatiz",passwordEncoder.encode("fatiz123"),"GERANT","");
        

        Employe employe = new Conseiller();
        employe.setNom("Ouakrim");
        employe.setPrenom("Youness");
        dan.setEmploye(employe); 
        
        List<User> users = Arrays.asList(dan,admin,manager);
        
        

        // Save to db
        this.userRepository.saveAll(users);



    }
}



