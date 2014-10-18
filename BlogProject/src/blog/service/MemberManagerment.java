package blog.service;

import java.sql.SQLException;

import net.sf.json.JSONArray;
import blog.exception.RecordNotFoundException;
import blog.model.dao.MemberDAO;
import blog.model.dto.MemberBean;

public class MemberManagerment implements MemberManagermentIF {
	private static MemberManagerment instance = new MemberManagerment();
	public static MemberManagerment getInstance(){
		return instance;
	}
	
	public void insertMember(MemberBean member) throws SQLException{
		int result = 0;
		try {
			result = MemberDAO.insertMember(member);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public MemberBean selectMemberByID(String id) throws SQLException ,RecordNotFoundException{
		MemberBean member = null;
		try {
			member = MemberDAO.selectMemberByID(id);
			if(member == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return member;
	}
	
	public JSONArray selectMemberList() throws SQLException ,RecordNotFoundException{
		JSONArray list = null;
		try {
			list = MemberDAO.selectMemberList();
			if(list == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return list;
	}
	
	public void updateMemberByID(MemberBean bean) throws SQLException{
		int result  = 0;
		try {
			result = MemberDAO.updateMemberByID(bean);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void deleteMemberByID(String id) throws SQLException{
		int result =0;
		try {
			result = MemberDAO.deleteMemberByID(id);
			if(result ==0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}
