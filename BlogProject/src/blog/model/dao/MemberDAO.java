package blog.model.dao;

import java.sql.SQLException;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import blog.model.dto.MemberBean;
import blog.util.DBUtil;

public class MemberDAO {
	public static int insertMember(MemberBean member) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.insert("Member.insertMember", member);
		} finally {
			session.close();
		}
	}
	
	public static MemberBean selectMemberByID(String id) throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectOne("Member.selectMemberByID", id);
		} finally {
			session.close();
		}
	}

	public static JSONArray selectMemberList() throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		JSONArray array = null;
		try {
			return JSONArray.fromObject(session
					.selectList("Member.selectMemberList"));
		} finally {
			session.close();
		}
	}

	public static int updateMemberByID(MemberBean bean) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Member.updateMemberByID", bean);
		} finally {
			session.close();
		}
	}

	public static int deleteMemberByID(String id) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Member.deleteMemberByID", id);
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		JSONArray members = null;
		try {
			members = MemberDAO.selectMemberList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator allData = members.iterator();
		// sdf
		JSONObject jObj = null;
		while (allData.hasNext()) {
			jObj = (JSONObject) allData.next();
			System.out.println(jObj.get("userid"));
		}
	}

}