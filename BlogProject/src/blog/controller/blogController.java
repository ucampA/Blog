package blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class blogController extends HttpServlet {
    public blogController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("login")){
			login(request, response);
		}
		
	}
	
	
	

	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userid = request.getParameter("userid");
			String userpw = request.getParameter("userpw");
			//test¿ë ÄÚµå
			System.out.println("login --------------- in");
			request.setAttribute("userid", userid);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

}
