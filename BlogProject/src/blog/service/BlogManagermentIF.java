package blog.service;

import java.sql.SQLException;
import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dto.BlogBean;

public interface BlogManagermentIF {
	public List<BlogBean> selectAllPosts() throws SQLException ,RecordNotFoundException;
	
	public BlogBean selectPostByNo(int no) throws SQLException ,RecordNotFoundException;
	
	public void insertPost(BlogBean post) throws SQLException;
	
	public void updatePost(BlogBean post) throws SQLException;
	
	public int updateReadCount() throws SQLException ,RecordNotFoundException;
	
	public void deletePostByNo(int branchNo) throws SQLException ,RecordNotFoundException;
	
	public void deleteAllPosts() throws SQLException ,RecordNotFoundException;
}
