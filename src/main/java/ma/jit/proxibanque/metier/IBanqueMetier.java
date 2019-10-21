package ma.jit.proxibanque.metier;

import ma.jit.proxibanque.entities.Compte;

public interface IBanqueMetier {

	public Compte consulterCompte(Long code);
	public void verser(Long code,double montant);
	public void retirer(Long code,double montant);
	public void virement(Long code1,Long code2,double montant);
	
}
