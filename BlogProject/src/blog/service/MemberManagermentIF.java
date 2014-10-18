package blog.service;

import java.sql.SQLException;

import net.sf.json.JSONArray;
import blog.exception.RecordNotFoundException;
import blog.model.dto.MemberBean;

public interface MemberManagermentIF {
	public void insertMember(MemberBean member) throws SQLException;
	
	public MemberBean selectMemberByID(String id) throws SQLException ,RecordNotFoundException;
	
	public JSONArray selectMemberList() throws SQLException ,RecordNotFoundException;
	
	public void updateMemberByID(String id) throws SQLException;
	
	public void deleteMemberByID(String id) throws SQLException;
}
