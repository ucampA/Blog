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
import blog.model.dto.BlogBean;
import blog.model.dto.MemberBean;
import blog.service.BlogManagerment;
import blog.service.MemberManagerment;


public class blogController extends HttpServlet {
	private BlogManagerment blog = BlogManagerment.getInstance();
	private MemberManagerment member = MemberManagerment.getInstance();
	
    public blogController() {
        super();
    }

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
			login(request, response);
		}else if(action.equals("logout")){
			logout(request, response);
		}else if(action.equals("join")){
			join(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}else if(action.equals("updateSave")){
			updateSave(request, response);
		}else if(action.equals("getAllPosts")){
			getAllPosts(request, response);
		}else if(action.equals("write")){
			writeSave(request, response);
		}else if(action.equals("memberList")){
			memberList(request, response);
		}else if(action.equals("detailContent")){
			detailContent(request, response);
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) {
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
					System.out.println("비번 틀림");
				}
			}else{
				System.out.println("ID 틀림");
			}
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
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
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
	
	private void join(HttpServletRequest request, HttpServletResponse response) {
		MemberBean bean = new MemberBean();
		bean.setUserid(request.getParameter("id"));
		bean.setUserpw(request.getParameter("pw"));
		bean.setPhone(request.getParameter("phone"));
		bean.setName(request.getParameter("name"));
		bean.setType('U');
		bean.setBlogname(request.getParameter("title"));
		try {
			//MemberDAO.insertMember(bean);
			member.insertMember(bean);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) {
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
	
	private void updateSave(HttpServletRequest request,
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

	private void getAllPosts(HttpServletRequest request, HttpServletResponse response) {
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
	
	private void writeSave(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userid = (String) session.getAttribute("userid");
		try {
			blog.insertPost(new BlogBean(title, content, userid));
			request.getRequestDispatcher("con?action=getAllPosts").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void memberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("members", MemberDAO.selectMemberList());
			request.getRequestDispatcher("index.jsp?page=admin/memberList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("발생위치 bloController.memberList");
		}
	}
	
	private void detailContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BlogBean bean;
			bean = blog.selectPostByNo(Integer.parseInt(request.getParameter("no")));
			request.setAttribute("blog", bean);
			request.getRequestDispatcher("index.jsp?page=blog/detailContent.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("발생위치 bloController.memberList");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
}
