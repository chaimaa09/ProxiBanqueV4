package ma.jit.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.proxibanque.entities.Compte;

/**
 * 
 * @author FOLIO Groupe D
 *
 */

/**
 * 
 * c'est une interface qui contient les methodes CRUD du conseiller
 *
 */
public interface ICompteDAO extends JpaRepository<Compte,Long > {

}
