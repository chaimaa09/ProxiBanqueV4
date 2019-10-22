package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.proxibanque.entities.Gerant;

/**
 * 
 * @author Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du Gérant
 *
 */
public interface GerantRepository extends JpaRepository<Gerant, Integer>{
	
}
