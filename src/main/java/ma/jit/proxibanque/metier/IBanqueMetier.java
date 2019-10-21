package ma.jit.proxibanque.metier;

import ma.jit.proxibanque.entities.Compte;

public interface IBanqueMetier {

//	public Compte consulterCompte(Long code);
	void verser(int codeC, double montant);
	void retirer(int codeD, double montant);
	boolean virement(int codeD, int codeC, double montant);
	
}
