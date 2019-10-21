/**
 * 
 */
package ma.jit.proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxibanque.entities.Parametrage;
import ma.jit.proxibanque.metier.IParametrageMetier;

/**
 * @author Groupe D
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParametrageController {
	
	@Autowired
	IParametrageMetier parametrageService;
	
	@PutMapping("/parametrage/{id}")
	public Parametrage updateParametrage(@PathVariable Long id,@RequestBody Parametrage parametrage) {
		return parametrageService.updateParametrage(id, parametrage);
	}
	
	@GetMapping("/parametrage/{id}")
	public Parametrage getParametrageById(@PathVariable Long id) {
		return parametrageService.getByID(id);
	}
	

}
