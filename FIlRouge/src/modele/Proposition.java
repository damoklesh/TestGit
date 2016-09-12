/**
 * 
 */
package modele;

/**
 * @Geoffroy
 *
 * 
 */
public class Proposition {
	
	/*Attribut*/
	
	private int    id_Prop;
	private String libelle_Prop;
	private int    reponse_Correcte;
	
	
	
	
	/*constructeur*/
	
	public Proposition(){
		
	}
	
	public Proposition (int MonId, String MonLib, int MaRepC){
		this.id_Prop          = MonId;
		this.libelle_Prop     = MonLib;
		this.reponse_Correcte =  MaRepC;
	}

	
	
	/*getter setter*/
	
	/**
	 * @return the id_Prop
	 */
	public int getId_Prop() {
		return id_Prop;
	}


	/**
	 * @return the libelle_Prop
	 */
	public String getLibelle_Prop() {
		return libelle_Prop;
	}


	/**
	 * @return the reponse_Correcte
	 */
	public int getReponse_Correcte() {
		return reponse_Correcte;
	}


	/**
	 * @param id_Prop the id_Prop to set
	 */
	public void setId_Prop(int id_Prop) {
		this.id_Prop = id_Prop;
	}


	/**
	 * @param libelle_Prop the libelle_Prop to set
	 */
	public void setLibelle_Prop(String libelle_Prop) {
		this.libelle_Prop = libelle_Prop;
	}


	/**
	 * @param reponse_Correcte the reponse_Correcte to set
	 */
	public void setReponse_Correcte(int reponse_Correcte) {
		this.reponse_Correcte = reponse_Correcte;
	}
	
	
	

}
