package blog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.exception.RecordNotFoundException;
import blog.model.dto.RepleBean;
import blog.service.ReplyManagement;

public class RepleServlet extends HttpServlet {
   private ReplyManagement re = new ReplyManagement().getInstance();

	public void send(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		RepleBean bean = new RepleBean();
		bean.setUserid((String) session.getAttribute("userId"));
		bean.setContent(request.getParameter("repleContent"));
		bean.setPno(Integer.parseInt(request.getParameter("pno")));
		
		System.out.println("Reple Send pno:"+request.getParameter("pno")+", id:"+session.getAttribute("userId")+",con" +request.getParameter("repleContent"));
		
		try {
			re.sendReple(bean);
			request.getRequestDispatcher("con?action=detailContent").forward(request, response);
		} catch (Exception e){
			System.out.println("���� ����");
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) {
		int pno = Integer.parseInt(request.getParameter("pno"));
		try {
			request.setAttribute("repleList", re.repleList(pno));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
