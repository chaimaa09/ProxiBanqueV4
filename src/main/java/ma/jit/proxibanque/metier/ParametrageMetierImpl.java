/**
 * 
 */
package ma.jit.proxibanque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.IParametrageRepository;
import ma.jit.proxibanque.entities.Parametrage;

/**
 * @author Groupe D
 *
 */
@Service
public class ParametrageMetierImpl implements IParametrageMetier {

	@Autowired
	private IParametrageRepository parametrageRepository;

	@Override
	public Parametrage updateParametrage(Long id, Parametrage parametrage) {
		parametrage.setId(id);
		return parametrageRepository.save(parametrage);
	}

	@Override
	public Parametrage getByID(Long id) {
		
		return parametrageRepository.getOne(id);
	}

}
