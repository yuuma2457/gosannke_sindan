package cc.shinbi.shindan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.shinbi.shindan.model.Shindan;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TopServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Shindan shindan = Shindan.createShindan();
		request.setAttribute("shindan", shindan);
		session.setAttribute("shindan", shindan);
		
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
		}

	

}
