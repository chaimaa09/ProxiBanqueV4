package ma.jit.proxibanque.metier;

import ma.jit.proxibanque.entities.Compte;

public interface IBanqueMetier {

//	public Compte consulterCompte(Long code);
	
	void retirer(int codeD, double montant);
//	void verser(long idParametrage, int codeC, double montant);
//	boolean virement(long idParametrage, int codeD, int codeC, double montant);
	void verser(int codeC, double montant);
	boolean virement(int codeD, int codeC, double montant);
	
}
