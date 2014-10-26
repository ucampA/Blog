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
		bean.setUserid((String) session.getAttribute("userid"));
		bean.setContent(request.getParameter("repleContent"));
		bean.setPno(Integer.parseInt(request.getParameter("pno")));
		
		System.out.println("Reple Send pno:"+request.getParameter("pno")+", id:"+session.getAttribute("userid")+",con:" +request.getParameter("repleContent"));
		
		try {
			re.sendReple(bean);
			//list(request, response);
			//request.getRequestDispatcher("con?action=detailContent").forward(request, response);
		} catch (Exception e){
			System.out.println("리플 오류");
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("reple list pno:"+request.getParameter("pno"));
		int pno = Integer.parseInt(request.getParameter("pno"));
		try {
			System.out.println("reple List : "+re.repleList(pno));
			request.setAttribute("repleList", re.repleList(pno));
			request.getRequestDispatcher("reple/repleList.jsp").forward(request, response);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
