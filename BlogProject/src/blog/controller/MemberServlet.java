package blog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.exception.RecordNotFoundException;
import blog.model.dao.MemberDAO;
import blog.model.dto.MemberBean;
import blog.service.MemberManagerment;

public class MemberServlet extends HttpServlet {
	private MemberManagerment member = MemberManagerment.getInstance();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String userid = request.getParameter("userid");
			String userpw = request.getParameter("userpw");
			//test용 코드
			MemberBean bean = member.selectMemberByID(userid);
			if(bean!=null){
				if(bean.getUserpw().equals(userpw)){
					session.setAttribute("userid", userid);
					session.setAttribute("blogName", member.selectMemberByID(userid).getBlogname());
				}else{
					request.setAttribute("msg", "PASSWORD 에러");
					request.getRequestDispatcher("index.jsp?page=msg/failed.jsp").forward(request, response);
					return;
				}
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			request.setAttribute("msg", "등록된 ID가 없습니다.");
			request.getRequestDispatcher("index.jsp?page=msg/failed.jsp").forward(request, response);
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean bean = new MemberBean();
		bean.setUserid(request.getParameter("id"));
		bean.setUserpw(request.getParameter("pw"));
		bean.setPhone(request.getParameter("phone"));
		bean.setName(request.getParameter("name"));
		bean.setType('U');
		bean.setBlogname(request.getParameter("title"));
		try {
			member.insertMember(bean);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			request.setAttribute("msg", "가입실패 ID 중복");
			request.getRequestDispatcher("index.jsp?page=msg/failed.jsp").forward(request, response);
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) {
		MemberBean bean = new MemberBean();
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		try {
			request.setAttribute("bean",member.selectMemberByID(userid));
			request.getRequestDispatcher("index.jsp?page=member/update.jsp").forward(request, response);
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
	
	protected void updateSave(HttpServletRequest request,
			HttpServletResponse response) {
		MemberBean bean = new MemberBean();
		bean.setUserid(request.getParameter("id"));
		bean.setUserpw(request.getParameter("pw"));
		bean.setPhone(request.getParameter("phone"));
		bean.setName(request.getParameter("name"));
		bean.setType('U');
		bean.setBlogname(request.getParameter("title"));
		try {
			member.updateMemberByID(bean);
			request.getSession().setAttribute("blogName", member.selectMemberByID(bean.getUserid()).getBlogname());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void memberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("members", MemberDAO.selectMemberList());
			request.getRequestDispatcher("index.jsp?page=admin/memberList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMemberByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(MemberDAO.deleteMemberByID(request.getParameter("id"))!=0){
				if(request.getSession().getAttribute("userid").equals("admin")){
					return;
				}else{
					request.getSession().invalidate();
					request.setAttribute("msg", "탈퇴성공");
					request.getRequestDispatcher("index.jsp?page=msg/success.jsp").forward(request, response);
					return;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
