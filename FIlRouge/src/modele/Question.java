/**
 * 
 */
package modele;

import java.util.ArrayList;

/**
 * @Geoffroy
 *
 * 
 */
public class Question {
	
	/*Attribut modele*/ 
	
	private int    					  numQuestion;
	private int                       niveauDifficulte;
	private String 					  intituleQuestion;
	private ArrayList<Proposition>    listProposition   =  new ArrayList<Proposition>(); 
	private static int				  autoID			= 1;
	
	
	/*constructeur*/

	public Question () {
		this.numQuestion      =  autoID;
		this.niveauDifficulte =  7;
		this.intituleQuestion =  "intitule question"+autoID;
		listProposition.add(new Proposition(1,"prop1",0));
		listProposition.add(new Proposition(2,"prop2",1));
		listProposition.add(new Proposition(3,"prop3",1));
		
		//incrementer id
		autoID++;
	}
	 
	/*getter et setter*/
	
	/**
	 * @return the numQuestion
	 */
	public int getNumQuestion() {
		return numQuestion;
	}


	/**
	 * @return the intituleQuestion
	 */
	public String getIntituleQuestion() {
		return intituleQuestion;
	}


	/**
	 * @return the listProposition
	 */
	public ArrayList<Proposition> getListProposition() {
		return listProposition;
	}

	public int getNiveauDifficulte() {
		return niveauDifficulte;
	}
	/**
	 * @param numQuestion the numQuestion to set
	 */
	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}


	/**
	 * @param intituleQuestion the intituleQuestion to set
	 */
	public void setIntituleQuestion(String intituleQuestion) {
		this.intituleQuestion = intituleQuestion;
	}


	/**
	 * @param listProposition the listProposition to set
	 */
	public void setListProposition(ArrayList<Proposition> listProposition) {
		this.listProposition = listProposition;
	}


	public void setNiveauDifficulte(int niveauDifficulte) {
		this.niveauDifficulte = niveauDifficulte;
	}
	 

}
