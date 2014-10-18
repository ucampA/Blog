package step03.cookie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
			//쿠키생성 
			Cookie userId = new Cookie("id", id);
			Cookie message = new Cookie("msg", "hi");
			
			//쿠키 lifetime 설정
			userId.setMaxAge(60*60*24*365);//365일
			message.setMaxAge(360);//6분
			
			//client에 전송
			response.addCookie(userId);
			response.addCookie(message);
			
			//request.getRequestDispatcher("successSession").forward(request, response);
			response.sendRedirect("successCookie");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "무효합니다.");
			response.sendRedirect("failCookie");
		}
    }
}





