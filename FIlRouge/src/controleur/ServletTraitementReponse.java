package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Question;
import modele.ScoreBean;
import modele.TraitementReponse;

/**
 * Servlet implementation class ServletTraitementReponse
 */
@WebServlet("/ServletTraitementReponse")
public class ServletTraitementReponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTraitementReponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//r�cuperer param�tres
		int index = Integer.parseInt(request.getParameter("index"));  //le index de la question
		
		//r�cuperer liste de questions
		ArrayList<Question> questionList = new ArrayList<Question>();
		questionList = (ArrayList<Question>) request.getSession().getAttribute("Questions");
		//r�cuperer la question actuelle
		Question RecupQuestion = questionList.get(index);
		//r�cuperer le objet score
		ScoreBean scoreO = (ScoreBean)request.getSession().getAttribute("score");
		
		//d�claration de un liste pour la r�ponse utilisateur
		ArrayList<String> listRepFrom = new ArrayList<String>();
		TraitementReponse traiterRep = new TraitementReponse();   //objet pour traiter la reponse
		
		//recuperer les propositions et les etats associés
		/*NO AJAX
		if (request.getParameterValues("rep_radio") != null ){
			Collections.addAll(listRepFrom,request.getParameterValues("rep_radio"));
		}
		else if (request.getParameterValues("rep_case") != null ){
			Collections.addAll(listRepFrom,request.getParameterValues("rep_case"));
		}
		
		for(int i = 0; i<listRepFrom.size();i++) {
			System.out.println("choix" + listRepFrom.get(i));
		}*/
		
		//r�cuperer les params pass�s par la requete AJAX et les mettre dans la liste listRepFrom
		//AJAX
		String liste = "";
		liste = request.getParameter("valeur");
		
		//si il y a des param�tres faire
		if (liste.length() > 0) {
		
			//formater la chaine en une ArrayList<String>
			listRepFrom = traiterRep.stringToListResp(liste);
					
			//cr�ation de la r�ponse
			ArrayList<Integer> rep = traiterRep.createResponse(listRepFrom, RecupQuestion.getListProposition().size());
			
			//cr�ation de la solution � partir de la question
			ArrayList<Integer> sol = traiterRep.createSolution(RecupQuestion.getListProposition());
			
			//v�rifier si la r�ponse est correcte
			boolean correct = traiterRep.checkResponde(rep, sol);
			
			//add score
			scoreO.setScore(index, correct);
			scoreO.afficherConsole();
			System.out.println("score: " +scoreO.getScore());
			
			//g�n�rer response xml pour la request AJAX
			//AJAX
			 response.setContentType("text/xml");
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().write("<message>"+correct+"</message>"); // "<score>hola</score>"
			 
		}
		
		//sinon renvoyer message
		else {
		//g�n�rer response xml pour la request AJAX
		//AJAX
		 response.setContentType("text/xml");
		 response.setHeader("Cache-Control", "no-cache");
		 response.getWriter().write("<message>erreur</message>"); // "<score>hola</score>"
		 
		}
		
		//NO AJAX
		/*request.setAttribute("resolve", correct);
		
		getServletContext().getRequestDispatcher("/WEB-INF/correct.jsp").forward(request,response) ;*/
	}
}
