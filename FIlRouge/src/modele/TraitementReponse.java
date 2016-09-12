/**
 * 
 */
package modele;

import java.util.ArrayList;

/**
 * @Steve
 *
 * 
 */
public class TraitementReponse {

	
	//comparér le arraylist de réponses entrées par l'utilisateur avec les proposition de la question passé
	public boolean checkResponde(ArrayList<Integer> resp, ArrayList<Integer> solution) {
		
		//balayer les deux tables au meme temps et comparer pair à pair
		for (int i=0; i< resp.size();i++) {
			
			//récuperer la valeur de la réponse
			//si la réponse et la solution sont différentes, sortir et renvoyer false
			if (resp.get(i) != solution.get(i)) return false;
		}
		
		//si on arrive jusqu'a ici, on est bon
		return true;
	}
	
	
	//cette méthode crée une réponse formatée 0,1
	//la méthode insert un 1 là ou l'utilisateur a coché une case et 0 pour les autres
	public ArrayList<Integer> createResponse(ArrayList<String> choix, int nombreProps) {
		
		int cpt = 0;
		ArrayList<Integer> response = new ArrayList<Integer>();
		
		for (int i= 0; i< nombreProps;i++) {
			//System.out.println("cpt: "+cpt);
			//System.out.println("i: "+i);
			//si on est sur me case qui designe le choix, insérer un 1
			if (i == Integer.parseInt(choix.get(cpt))) {
				response.add(1);
				//System.out.println("igual: "+i+" = "+Integer.parseInt(choix.get(cpt)));
				//incrémenter cpt
				if (cpt < choix.size()-1) cpt++;

			}
			else {
				response.add(0);
				//System.out.println("no igual: "+i+" != "+Integer.parseInt(choix.get(cpt)));
			}
			//System.out.println("createreponse"+i+" "+response.get(i) );
		}
		return response;
	}
	
	public ArrayList<Integer> createSolution(ArrayList<Proposition> propList) {
		
		ArrayList<Integer> solution = new ArrayList<Integer>();
		
		//balayer les propositions et copier la valeur de la solution
		for (Proposition proposition : propList) {
			solution.add(proposition.getReponse_Correcte());
			//System.out.println("createsolution" + solution.get(solution.size()-1) );
		}
		
		return solution;
		
	}
	
	//cette méthode va formater une chaine avec les choix de l'utilisateur dans une ArrayList 
	public ArrayList<String> stringToListResp (String chaine) {
		
		ArrayList<String> liste = new ArrayList<String>();  //liste à retourner
		
		for(int i=0;i<chaine.length();i++) {
			
			if (chaine.charAt(i)!= ',') liste.add(Character.toString(chaine.charAt(i)));
		}
		
		/*for(int i=0;i<liste.size();i++) {
			
			//System.out.println(liste.get(i));
		}*/
		
		
		return liste;
		
	}

}
