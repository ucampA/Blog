package blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class blogController extends HttpServlet {
	private MemberServlet ms = new MemberServlet();
	private PostServlet ps = new PostServlet();
	
    public blogController() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String action = request.getParameter("action");
		if(action.equals("login")){
			ms.login(request, response);
		}else if(action.equals("logout")){
			ms.logout(request, response);
		}else if(action.equals("join")){
			ms.join(request, response);
		}else if(action.equals("update")){
			ms.update(request, response);
		}else if(action.equals("updateSave")){
			ms.updateSave(request, response);
		}else if(action.equals("getAllPosts")){
			ps.getAllPosts(request, response);
		}else if(action.equals("write")){
			ps.writeSave(request, response);
		}else if(action.equals("memberList")){
			ms.memberList(request, response);
		}else if(action.equals("detailContent")){
			ps.detailContent(request, response);
		}
	}
}
