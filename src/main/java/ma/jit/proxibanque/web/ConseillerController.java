/**
 * 
 */
package ma.jit.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxibanque.entities.Conseiller;
import ma.jit.proxibanque.metier.IConseillerMetier;

/**
 * @author Group D
 *
 */
@RestController
@RequestMapping("/api")
public class ConseillerController {

	@Autowired
	IConseillerMetier conseillerService;
	
	@GetMapping("/conseillers")
	public List<Conseiller> getAll(){
		return conseillerService.listeConseillers();
		
	}
	
	@GetMapping("/conseillers/{code}")
	public Conseiller getConseillerById(@PathVariable(value = "code") Long code) {
		return conseillerService.consulterConseiller(code);
		
	}
	
	@PostMapping("/conseillers")
	public Conseiller addConseiller(@RequestBody Conseiller c) {
		return conseillerService.ajouterConseiller(c);
		
	}
	 @DeleteMapping("/conseillers/{code}")
	public void deleteConseiller(@PathVariable(value = "code")Long code) {
		conseillerService.supprimerConseiller(code);
	}
	
	 @PutMapping("/conseillers/{code}")
	 public Conseiller updateConseiller(@PathVariable(value = "code")Long code,@RequestBody Conseiller c) {
		 return conseillerService.modifierConseiller(code, c);
	 }
	

}
