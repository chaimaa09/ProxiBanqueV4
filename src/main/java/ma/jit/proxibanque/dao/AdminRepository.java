package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.proxibanque.entities.Admin;

/**
 * 
 * @author Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du Admin
 *
 */
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
