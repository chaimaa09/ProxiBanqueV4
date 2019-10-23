package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.proxibanque.entities.Client;

/**
 * 
 * @author  Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du Client
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	

}
