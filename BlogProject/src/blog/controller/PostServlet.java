package blog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.exception.RecordNotFoundException;
import blog.model.dto.PostBean;
import blog.service.BlogManagerment;

public class PostServlet extends HttpServlet {
	private BlogManagerment blog = BlogManagerment.getInstance();
	
	protected void getAllPosts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			request.setAttribute("postList", BlogManagerment.getInstance().selectAllPosts((String) session.getAttribute("userid")));
			request.getRequestDispatcher("index.jsp?page=board/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void writeSave(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userid = (String) session.getAttribute("userid");
		String openState = request.getParameter("openState");
		
		try {
			blog.insertPost(new PostBean(title, content, userid, openState));
			request.getRequestDispatcher("con?action=getAllPosts").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void detailContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("blog", blog.selectPostByNo(Integer.parseInt(request.getParameter("pno"))));
			request.getRequestDispatcher("index.jsp?page=blog/detailContent.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("발생위치 bloController.detailContent");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void updatePost(HttpServletRequest request, HttpServletResponse response){
		int pno = Integer.parseInt(request.getParameter("pno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String openState = request.getParameter("openState");
		
		try {
			blog.updatePost(new PostBean(pno, title, content, openState));
			getAllPosts(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void deletePost(HttpServletRequest request, HttpServletResponse response){
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("deletePost");
		try {
			blog.deletePostByNo(pno);
			getAllPosts(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
}
