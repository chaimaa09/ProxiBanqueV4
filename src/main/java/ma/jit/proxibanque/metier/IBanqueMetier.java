package ma.jit.proxibanque.metier;



public interface IBanqueMetier {

	
	public void verser(int codeC,double montant);
	public void retirer(int codeD,double montant);
	public boolean virement(int codeD,int codeC,double montant);
//	Compte consulterCompte(Long code);
	
}
