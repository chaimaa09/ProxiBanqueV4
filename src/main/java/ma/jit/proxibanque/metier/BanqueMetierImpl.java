package ma.jit.proxibanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.CompteRepository;
import ma.jit.proxibanque.dao.IParametrageRepository;
import ma.jit.proxibanque.dao.OperationRepository;
import ma.jit.proxibanque.entities.Compte;
import ma.jit.proxibanque.entities.CompteCourant;
import ma.jit.proxibanque.entities.Parametrage;
import ma.jit.proxibanque.entities.Retrait;
import ma.jit.proxibanque.entities.Versement;

@Service
public class BanqueMetierImpl implements IBanqueMetier {
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	IParametrageRepository parametrageRepository;
	/*
	 * @Override public CompteCourant consulterCompte(Long code) {
	 * 
	 * CompteCourant compte= compteRepository.getOne(code);
	 * System.out.println(compte); if(compte==null) throw new
	 * RuntimeException("Compte introuvable"); return compte; }
	 */


	@Override
	public void verser(int codeC, double montant) {
		Compte crediteur= compteRepository.findById(codeC).get();
		Parametrage parametrage = parametrageRepository.findById(1L).get();
		double commision = montant * parametrage.getCommission();
		double montantFinal = montant - commision;
		Versement opv=new Versement(new Date(), montant, crediteur);
		operationRepository.save(opv);
		crediteur.setSolde(crediteur.getSolde()+montantFinal);
		
		compteRepository.save(crediteur);
		
		
	}

	@Override
	public void retirer(int codeD, double montant) {
		Compte debiteur=compteRepository.getOne(codeD);
		Retrait opr=new Retrait(new Date(), montant, debiteur);
		
		double soldeDebiteur=debiteur.getSolde();
		double faciliteCaisse=0;
		if(debiteur instanceof CompteCourant)
		faciliteCaisse=((CompteCourant) debiteur).getDecouvert();
		if(soldeDebiteur+faciliteCaisse<montant)
		throw new RuntimeException("Solde Insuffisant !");
		operationRepository.save(opr);
		debiteur.setSolde(soldeDebiteur-montant);
		compteRepository.save(debiteur);

	}

	@Override
	public boolean virement(int codeD, int codeC, double montant) {
//		if(codeD.equals(codeC))
//			throw new RuntimeException("impossible de virer sur le meme compte !");
			retirer(codeD,montant);
			verser(codeC,montant);
			return true;
	}

}
