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
			//��û ��ü�� "name=���" ������ ������ ���� ����
			request.setAttribute("name", "���");
			
			RequestDispatcher pageMove = request.getRequestDispatcher("success");
			pageMove.forward(request, response);
		}else{
			request.setAttribute("msg", "���� ����");
			response.sendRedirect("fail");
		}
    }
}





