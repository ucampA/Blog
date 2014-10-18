package step02.session.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckController extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("LoginCheck doGet()");
    	process(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("LoginCheck doPost()");
    	process(request, response);
    }
    protected void process(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("tester") && pw.equals("11")){
			//세션 생성 
			HttpSession session = request.getSession();
			//세션에 상태유지를 위한 데이터 저장
			session.setAttribute("sucMsg", "유효한 id입니다.");				
			
			System.out.println("LoginCheckController " + session.getId());
			
			request.getRequestDispatcher("successSession").forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "무효합니다.");
			response.sendRedirect("failSession");
		}
    }
}





