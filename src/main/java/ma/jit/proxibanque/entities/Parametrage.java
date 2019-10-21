/**
 * 
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Groupe D
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parametrage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double commission;
	private boolean graphe;
	private int nombreMaxClient;
	private int nombreMaxConseiller;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the commission
	 */
	public double getCommission() {
		return commission;
	}


	/**
	 * @param commission the commission to set
	 */
	public void setCommission(double commission) {
		this.commission = commission;
	}


	/**
	 * @return the graphe
	 */
	public boolean isGraphe() {
		return graphe;
	}


	/**
	 * @param graphe the graphe to set
	 */
	public void setGraphe(boolean graphe) {
		this.graphe = graphe;
	}


	/**
	 * @return the nombreMaxClient
	 */
	public int getNombreMaxClient() {
		return nombreMaxClient;
	}


	/**
	 * @param nombreMaxClient the nombreMaxClient to set
	 */
	public void setNombreMaxClient(int nombreMaxClient) {
		this.nombreMaxClient = nombreMaxClient;
	}


	/**
	 * @return the nombreMaxConseiller
	 */
	public int getNombreMaxConseiller() {
		return nombreMaxConseiller;
	}


	/**
	 * @param nombreMaxConseiller the nombreMaxConseiller to set
	 */
	public void setNombreMaxConseiller(int nombreMaxConseiller) {
		this.nombreMaxConseiller = nombreMaxConseiller;
	}


	/**
	 * 
	 */
	public Parametrage() {
		super();
	}


	/**
	 * @param commission
	 * @param graphe
	 * @param nombreMaxClient
	 * @param nombreMaxConseiller
	 */
	public Parametrage(double commission, boolean graphe, int nombreMaxClient, int nombreMaxConseiller) {
		super();
		this.commission = commission;
		this.graphe = graphe;
		this.nombreMaxClient = nombreMaxClient;
		this.nombreMaxConseiller = nombreMaxConseiller;
	}

}
