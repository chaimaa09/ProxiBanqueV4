package ma.jit.proxibanque.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.entities.Agence;
import ma.jit.proxibanque.entities.CompteAgence;
import ma.jit.proxibanque.entities.Conseiller;
import ma.jit.proxibanque.entities.Employe;
import ma.jit.proxibanque.entities.User;


@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AgenceRepository agenceRepository;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder,AgenceRepository agenceRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
       this.userRepository.deleteAll();
       this.agenceRepository.deleteAll();

        // Create users
        User dan = new User("nabila",passwordEncoder.encode("nabila123"),"Moderateur","");
        User admin = new User("chaimaa",passwordEncoder.encode("chaimaa123"),"CONSEILLER","");
        User manager = new User("fatiz",passwordEncoder.encode("fatiz123"),"GERANT","");
        
        //create agence
        CompteAgence compteAgence = new CompteAgence();
		Agence agence = new Agence();
		compteAgence.setDateCreation(new Date());
//		compteAgence.setSolde(0);
		agence.setCompteAgence(compteAgence);

//        Employe employe = new Conseiller();
//        employe.setNom("Ouakrim");
//        employe.setPrenom("Youness");
//        dan.setEmploye(employe); 
        
        List<User> users = Arrays.asList(dan,admin,manager);
        
        

        // Save to db
        this.userRepository.saveAll(users);
        this.agenceRepository.save(agence);



    }
}



