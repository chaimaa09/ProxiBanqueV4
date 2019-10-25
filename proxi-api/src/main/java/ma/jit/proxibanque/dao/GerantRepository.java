package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long>{
	
}
