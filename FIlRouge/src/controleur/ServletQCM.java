package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Question;
import modele.ScoreBean;

/**
 * Servlet implementation class ServletQCM
 */
@WebServlet("/ServletQCM")
public class ServletQCM extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final int nbrQuestions			   = 10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletQCM() { 
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
		
		ArrayList<Question> questions = new ArrayList<Question>();  //liste des questions
		ScoreBean scoreOb = new ScoreBean();
		
		//instancier une liste de question pour le QCM actuelle
		for (int i=0;i<=nbrQuestions; i++) {
			
			questions.add(new Question());
			
		}
		
		HttpSession  session = request.getSession(); //recupêrer l'attribut "session" de la requet
		session.setAttribute("Questions", questions);
		session.setAttribute("score",scoreOb);
				
		getServletContext().getRequestDispatcher("/QCM.jsp").forward(request,response) ;
	}

}
