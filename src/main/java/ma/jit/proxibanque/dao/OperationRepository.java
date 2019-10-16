package ma.jit.proxibanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

//	@Query("select o from Operation o where o.compte.code like :x order by o.dateOp desc")
//	public Page<Operation> listOperation(@Param("x")String codeCte,Pageable page);
}
