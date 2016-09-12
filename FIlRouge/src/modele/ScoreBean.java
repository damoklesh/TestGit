/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Steve
 *
 */
public class ScoreBean {

		//attributs
		private int score;
		//private ArrayList<Boolean> questionesRep = new ArrayList<Boolean>();   //cette liste va a stocker vrai ou faux pour chaque question
		private HashMap<Integer,Boolean> questionesRep = new HashMap<Integer,Boolean>();   //cette liste va a stocker vrai ou faux pour chaque question
		
		
		//accesseurs
		public int getScore () {
			score = 0;
			
			for (Boolean bool : questionesRep.values()) {
				
				if (bool == Boolean.TRUE) score++;
			}
			
			return score;
		}
		
		public void incrScore() {
			score++;
		}
		
		//constructeur
		public ScoreBean() {
			score = 0;
		}
		
		public void setScore(int index, boolean resultat) {
			//ARRYALIST
			/*//si le element existe déjà, supprimer
			if (questionesRep.size()>index) questionesRep.remove(index);
			//rajouter nouveau element
			if (index < questionesRep.size())questionesRep.add(index, resultat);
			//si l'index est superieur à la taille, rajouter à la fin
			else questionesRep.add(resultat);*/
			
			//HASHMAP
			questionesRep.put(index, resultat);
			System.out.println("index "+index);
		}
		
		public void afficherConsole () {
			//ARRAYLIST
			/*for (int i=0;i<questionesRep.size();i++) {
				
				System.out.println("Question"+i+" :"+questionesRep.get(i));
			}*/
			int cpt = 0;
			for (Integer key : questionesRep.keySet()) {
							
				System.out.println("Question"+key+" :"+questionesRep.get(key));
				cpt++;
			}
		}
		
		
		
}
