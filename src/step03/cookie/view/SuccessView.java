package step03.cookie.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessView extends HttpServlet {
	protected void doGet(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SuccessView doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SuccessView doPost()");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		Cookie [] allData = request.getCookies();
		String key = null;
		for(int i=0; i < allData.length ; i++){
			key = allData[i].getName();
			if(key.equals("id")){
				out.println("당신의 id는 " + allData[i].getValue() + "<br>");
			}else if(key.equals("msg")){
				out.println("당신의 메세지는 " + allData[i].getValue());
			}
		}
		
		out.close();
	}
}





