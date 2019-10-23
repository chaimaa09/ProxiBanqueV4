/**
 * 
 */
package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxibanque.entities.Parametrage;

/**
 * @author Groupe D
 *
 */
@Repository
public interface ParametrageRepository extends JpaRepository<Parametrage, Long> {

}
