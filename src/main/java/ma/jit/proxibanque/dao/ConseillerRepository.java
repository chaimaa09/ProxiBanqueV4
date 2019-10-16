
package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxibanque.entities.Conseiller;

/**
 * 
 * @author Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du conseiller
 *
 */
@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Long>{

}
