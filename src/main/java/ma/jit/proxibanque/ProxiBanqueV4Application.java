package ma.jit.proxibanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.jit.proxibanque.metier.BanqueMetierImpl;
import ma.jit.proxibanque.metier.IBanqueMetier;

@SpringBootApplication
public class ProxiBanqueV4Application {

	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueV4Application.class, args);
	
		
		IBanqueMetier banque = new BanqueMetierImpl();
		
		System.out.println(banque.consulterCompte(2L));
	}

}
