/**
 * c'est une classe qui represente un admin
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Groupe D
 *
 */
@Entity
public class Admin extends Employe implements Serializable {
	
	public Admin(String nom, String prenom) {
		super(nom, prenom);
	}


	private String login;
	private String password;

	/**
	 * constructeur sans parametres
	 */
	

	


	

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	public Admin() {
		
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	public Admin(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
	}

	/**
	 * @param prenom
	 * @param nom
	 * @param login
	 * @param password
	 */
//	public Admin(String prenom, String nom, String login, String password) {
//		super();
//		this.prenom = prenom;
//		this.nom = nom;
//		this.login = login;
//		this.password = password;
//	}
	
	

}
