package blog.service;

import java.sql.SQLException;
import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dao.MemberDAO;
import blog.model.dao.RepleDAO;
import blog.model.dto.RepleBean;

public class ReplyManagement {

	private static ReplyManagement instance = new ReplyManagement();
	public static ReplyManagement getInstance(){
		return instance;
	}
	
	
	public void sendReple(RepleBean bean) throws SQLException {
		int result = 0;
		try {
			result = RepleDAO.sendReple(bean);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}


	public List repleList(int pno) throws RecordNotFoundException, SQLException {
		List list = null;
		list = RepleDAO.repleList(pno);
		if(list == null){
			throw new RecordNotFoundException();
		}
		return list;
	}
}
