/**
 * 
 */
package ma.jit.proxibanque.metier;

import ma.jit.proxibanque.entities.Parametrage;

/**
 * @author Groupe D
 *
 */
public interface IParametrageMetier {
	
	public Parametrage updateParametrage(Long id, Parametrage parametrage);
	public Parametrage getByID(Long id);

}
