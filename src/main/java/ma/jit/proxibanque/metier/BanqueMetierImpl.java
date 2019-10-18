package ma.jit.proxibanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.CompteRepository;
import ma.jit.proxibanque.dao.OperationRepository;
import ma.jit.proxibanque.entities.Compte;
import ma.jit.proxibanque.entities.CompteCourant;
import ma.jit.proxibanque.entities.Retrait;
import ma.jit.proxibanque.entities.Versement;

@Service
public class BanqueMetierImpl implements IBanqueMetier {
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(Long code) {
		
		Compte compte= compteRepository.getOne(code);
		System.out.println(compte);
		if(compte==null) throw new RuntimeException("Compte introuvable");
		return compte;
	}

	@Override
	public void verser(Long code, double montant) {
		Compte compte=consulterCompte(code);
		Versement opv=new Versement(new Date(), montant, compte);
		operationRepository.save(opv);
		compte.setSolde(compte.getSolde()+montant);
		compteRepository.save(compte);
		
	}

	@Override
	public void retirer(Long code, double montant) {
		Compte compte=consulterCompte(code);
		Retrait opr=new Retrait(new Date(), montant, compte);
		
		double faciliteCaisse=0;
		if(compte instanceof CompteCourant)
		faciliteCaisse=((CompteCourant) compte).getDecouvert();
		if(compte.getSolde()+faciliteCaisse<montant)
		throw new RuntimeException("Solde Insuffisant !");
		operationRepository.save(opr);
		compte.setSolde(compte.getSolde()-montant);
		compteRepository.save(compte);

	}

	@Override
	public void virement(Long code1, Long code2, double montant) {
		if(code1.equals(code2))
			throw new RuntimeException("impossible de virer sur le meme compte !");
			retirer(code1,montant);
			verser(code2,montant);

	}

}
