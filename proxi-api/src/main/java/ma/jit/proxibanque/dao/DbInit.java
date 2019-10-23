//package ma.jit.proxibanque.dao;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//import ma.jit.proxibanque.entities.Agence;
//import ma.jit.proxibanque.entities.CompteAgence;
//
//import ma.jit.proxibanque.entities.Admin;
//
//import ma.jit.proxibanque.entities.Conseiller;
//import ma.jit.proxibanque.entities.Employe;
//import ma.jit.proxibanque.entities.Gerant;
//import ma.jit.proxibanque.entities.User;
//
//
//@Service
//public class DbInit implements CommandLineRunner {
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//    
//
//    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder,AgenceRepository agenceRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        
//    }
//
//    @Override
//    public void run(String... args) {
//        // Delete all
//       this.userRepository.deleteAll();
//       
//
//        // Create users
//        User nabila = new User("nabila",passwordEncoder.encode("nabila123"),"Moderateur","");
//        User chaimaa = new User("chaimaa",passwordEncoder.encode("chaimaa123"),"CONSEILLER","");
//        User fz = new User("fatiz",passwordEncoder.encode("fatiz123"),"GERANT","");
//        
//        //create agence
//        CompteAgence compteAgence = new CompteAgence();
//		Agence agence = new Agence();
//
//		agence.setCompteAgence(compteAgence);
//
//
//        Employe employe = new Conseiller();
//        employe.setNom("bb");
//        employe.setPrenom("chaimaa");
//        chaimaa.setEmploye(employe); 
//
//        
//        Employe employe1 = new Admin();
//        employe1.setNom("GG");
//        employe1.setPrenom("nabila");
//        nabila.setEmploye(employe1); 
//        
//        Employe employe2 = new Gerant();
//        employe2.setNom("SS");
//        employe2.setPrenom("fz");
//        fz.setEmploye(employe2); 
//        
//        List<User> users = Arrays.asList(chaimaa,nabila,fz);
//        
//        
//
//        // Save to db
//        this.userRepository.saveAll(users);
//       
//
//
//
//    }
//}
//
//
//
