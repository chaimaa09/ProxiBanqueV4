/**
 * 
 */
package ma.jit.proxibanque.metier;

import java.util.List;


import ma.jit.proxibanque.entities.Conseiller;

/**
 * @author Groupe D
 *
 */
public interface IConseillerMetier {
	public Conseiller consulterConseiller(Long code);
	public void supprimerConseiller(Long code);
	public Conseiller ajouterConseiller(Conseiller c);
	public Conseiller modifierConseiller(Long code, Conseiller c);
	public List<Conseiller> listeConseillers() ;

}
