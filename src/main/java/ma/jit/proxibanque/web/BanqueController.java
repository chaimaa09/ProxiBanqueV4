package ma.jit.proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxibanque.metier.IBanqueMetier;

@RestController
@RequestMapping("/api/operations")
public class BanqueController {

	@Autowired
	IBanqueMetier banqueService;
	
	@RequestMapping("/debiter")
	void debiter(@RequestParam(value="code1") Long code1, @RequestParam(value="mt") double montant) {
		banqueService.retirer(code1, montant);
	}
	
	@RequestMapping("/crediter")
	void crediter(@RequestParam(value="code1") Long code1, @RequestParam(value="mt") double montant) {
		banqueService.verser(code1, montant);
	}
	
	@RequestMapping("/virement")
	void virement(@RequestParam(value="code1") Long code1, @RequestParam(value="code2") Long code2, @RequestParam(value="mt") double montant) {
		banqueService.virement(code1, code2, montant);
	}
	
}
