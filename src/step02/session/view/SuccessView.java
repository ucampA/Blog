package step02.session.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//이미 해당 고객으로 생성된 HttpSession 객체 획득(생성 아님 유지)
		HttpSession session = request.getSession();
		System.out.println("SuccessView " + session.getId());
		
		//세션 객체로 부터 데이터 획득 
		String value = (String)session.getAttribute("sucMsg");		
		out.println(value);
		//더이상 사용되지 않는 세션 무효화
		session.invalidate();
		
		out.close();
	}
}





