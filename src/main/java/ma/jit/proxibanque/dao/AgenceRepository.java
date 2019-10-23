/**
 * 
 */
package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxibanque.entities.Agence;

/**
 * @author Groupe D
 *
 */
@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

}
