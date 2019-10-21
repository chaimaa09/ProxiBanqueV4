package ma.jit.proxibanque.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxibanque.metier.IBanqueMetier;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin
public class BanqueController {

	@Autowired
	IBanqueMetier banqueService;
	
//	@GetMapping("/consulter/{code}")
//	void consulterCompte(@PathVariable(value="code") Long code) {
//		banqueService.consulterCompte(code);
//	}
	
	@RequestMapping("/debiter")
	void debiter(@RequestParam(value="codeD") int codeD, @RequestParam(value="mt") double montant) {
		banqueService.retirer(codeD, montant);
	}
	
	@RequestMapping("/crediter")
	void crediter( @RequestParam(value="codeC") int codeC, @RequestParam(value="mt") double montant) {
		banqueService.verser(codeC, montant);
	}
	
//	@RequestMapping("/virement")
//	void virement(@RequestParam(value="codeD") Long codeD, @RequestParam(value="codeC") Long codeC, @RequestParam(value="mt") double montant) {
//		banqueService.virement(codeD, codeC, montant);
//	}
	@PutMapping("/virement")
	boolean virement(@RequestBody HashMap<String, Object> operation) {
		int debiteur =(int) operation.get("compteD");
		int crediteur = (int) operation.get("compteC");
		double montant = (int) operation.get("montant");
		
		return banqueService.virement( debiteur, crediteur, montant);

	}
	
}
