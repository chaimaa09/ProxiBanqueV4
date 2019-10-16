package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.proxibanque.entities.Admin;

/**
 * 
 * @author FOLIO Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du Admin
 *
 */
public interface IAdminDAO extends JpaRepository<Admin, Integer>{

}
