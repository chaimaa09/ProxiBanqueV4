package ma.jit.proxibanque.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.proxibanque.entities.Operation;

/**
 * 
 * @author FOLIO Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du gerant
 *
 */
public interface IOperationDAO extends JpaRepository<Operation, Long>{

}
