/**
 * 
 */
package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.proxibanque.entities.Agence;

/**
 * @author FOLIO 9740M
 *
 */
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

}
