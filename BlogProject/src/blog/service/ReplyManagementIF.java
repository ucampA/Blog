package blog.service;

import java.sql.SQLException;
import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dto.RepleBean;

public interface ReplyManagementIF {
	public void sendReple(RepleBean bean) throws SQLException;
	public List repleList(int pno) throws RecordNotFoundException, SQLException;
	public void deleteReple(int rno) throws RecordNotFoundException, SQLException;
	public void updateReple(RepleBean bean) throws SQLException;
}
