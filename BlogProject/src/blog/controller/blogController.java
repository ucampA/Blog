package blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class blogController extends HttpServlet {
	private MemberServlet ms = new MemberServlet();
	private PostServlet ps = new PostServlet();
	private RepleServlet rs = new RepleServlet();
	
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
		}else if(action.equals("updatePost")){
			ps.updatePost(request, response);
		}else if(action.equals("deletePost")){
			ps.deletePost(request, response);
		}else if(action.equals("getAllPostsForSearch")){
			ps.getAllPostsForSearch(request, response);
		}else if(action.equals("getPostByNo")){
			ps.detailContent(request, response);
		}else if(action.equals("deleteMemberByID")){
			ms.deleteMemberByID(request, response);
		}
		
		if(action.equals("sendReple")){
			rs.send(request,response);
		}else if(action.equals("repleList")){
			rs.list(request,response);
		}else if(action.equals("deleteReple")){
			rs.delete(request,response);
		}else if(action.equals("updateReple")){
			rs.update(request,response);
		}
	}
}
