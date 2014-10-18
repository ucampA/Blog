package step01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			//요청 객체에 "name=명미" 구조의 데이터 새로 저장
			request.setAttribute("name", "명미");
			
			RequestDispatcher pageMove = request.getRequestDispatcher("success");
			pageMove.forward(request, response);
		}else{
			request.setAttribute("msg", "원태 눈떠");
			response.sendRedirect("fail");
		}
    }
}





