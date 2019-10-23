
package ma.jit.proxibanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.CompteRepository;
import ma.jit.proxibanque.dao.ParametrageRepository;
import ma.jit.proxibanque.dao.OperationRepository;
import ma.jit.proxibanque.entities.Compte;
import ma.jit.proxibanque.entities.CompteCourant;
import ma.jit.proxibanque.entities.Parametrage;
import ma.jit.proxibanque.entities.Retrait;
import ma.jit.proxibanque.entities.Versement;
/**
 * @author  Groupe D
 *
 */
/**cette classe contient les methodes de banque
 * 
 */
@Service
public class BanqueMetierImpl implements IBanqueMetier {
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	ParametrageRepository parametrageRepository;
	

	/**cette methode sert a verser un montant
	 * 
	 */
	@Override
	public void verser(int codeC, double montant) {
		Compte compteCrediteur= compteRepository.findById(codeC).get();
		Parametrage parametrage = parametrageRepository.findById(0L).get();
		Compte compteAgence = compteRepository.findById(0).get();
		
		double commision = montant * parametrage.getCommission();
		double montantFinal = montant - commision;
		double soldeAgence = compteAgence.getSolde();
		compteAgence.setSolde(soldeAgence + commision);
		
		Versement opv=new Versement(new Date(), montant, compteCrediteur);
		operationRepository.save(opv);
		compteCrediteur.setSolde(compteCrediteur.getSolde()+montantFinal);
		
		compteRepository.save(compteCrediteur);
		
		
	}
	/**cette methode sert a retirer un montant
	 * 
	 */

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
	/**cette methode sert a effectuer un virement
	 * 
	 */
	@Override
	public boolean virement(int codeD, int codeC, double montant) {

			retirer(codeD,montant);
			verser(codeC,montant);
			return true;
	}

}
