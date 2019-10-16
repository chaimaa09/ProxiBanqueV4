/**
 * 
 */
package ma.jit.proxibanque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.ConseillerRepository;

import ma.jit.proxibanque.entities.Conseiller;

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

	@Override
	public Conseiller consulterConseiller(Long code) {
		
		return conseillerRepository.getOne(code);
	}

	@Override
	public void supprimerConseiller(Long code) {
		conseillerRepository.deleteById(code);

	}

	@Override
	public Conseiller ajouterConseiller(Conseiller c) {
		
		return conseillerRepository.save(c);
	}

	@Override
	public Conseiller modifierConseiller(Long code, Conseiller c) {
		Conseiller conseiller = this.consulterConseiller(code);
		conseiller.setNom(c.getNom());
		conseiller.setPrenom(c.getPrenom());
		
		return conseillerRepository.save(conseiller) ;
		
	}

	@Override
	public List<Conseiller> listeConseillers() {
		
		return conseillerRepository.findAll();
	}

}
