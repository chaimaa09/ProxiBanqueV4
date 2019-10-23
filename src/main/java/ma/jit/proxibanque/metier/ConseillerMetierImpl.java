/**
 * 
 */
package ma.jit.proxibanque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.ConseillerRepository;
import ma.jit.proxibanque.dao.GerantRepository;
import ma.jit.proxibanque.dao.ParametrageRepository;
import ma.jit.proxibanque.entities.Conseiller;
import ma.jit.proxibanque.entities.Gerant;
import ma.jit.proxibanque.entities.Parametrage;

/**
 * @author Group D
 *
 */
/**
 * c'est la classe qui permet d'implémenter les methodes metier Conseiller
 */
@Service
public class ConseillerMetierImpl implements IConseillerMetier {

	@Autowired
	ConseillerRepository conseillerRepository;

	@Autowired
	GerantRepository gerantRepository;

	@Autowired
	ParametrageRepository parametrageRepository;

	@Override
	public Conseiller consulterConseiller(Long code) {

		return conseillerRepository.getOne(code);
	}

	@Override
	public void supprimerConseiller(Long code) {
		conseillerRepository.deleteById(code);

	}

	@Override
	public Conseiller ajouterConseiller(Conseiller conseiller) {
		Parametrage parametrage = parametrageRepository.findById(1L).get();
		Gerant gerant = gerantRepository.getOne(0);
		if (gerant.getConseiller().size() < parametrage.getNombreMaxConseiller()) {
			return conseillerRepository.save(conseiller);
		} else
			return conseiller;
	}

	@Override
	public Conseiller modifierConseiller(Long code, Conseiller c) {
		Conseiller conseiller = this.consulterConseiller(code);
		conseiller.setNom(c.getNom());
		conseiller.setPrenom(c.getPrenom());

		return conseillerRepository.save(conseiller);

	}

	@Override
	public List<Conseiller> listeConseillers() {

		return conseillerRepository.findAll();
	}

}
