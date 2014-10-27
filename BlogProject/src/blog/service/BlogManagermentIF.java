package blog.service;

import java.sql.SQLException;
import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dto.PostBean;

public interface BlogManagermentIF {
	public List<PostBean> selectAll() throws SQLException ,RecordNotFoundException;
	
	public List<PostBean> selectAllPosts(String userid) throws SQLException ,RecordNotFoundException;
	
	public PostBean selectPostByNo(int no) throws SQLException ,RecordNotFoundException;
	
	public void insertPost(PostBean post) throws SQLException;
	
	public void updatePost(PostBean post) throws SQLException;
	
	public int updateReadCount(int pno) throws SQLException ,RecordNotFoundException;
	
	public void deletePostByNo(int branchNo) throws SQLException ,RecordNotFoundException;
	
	public void deleteAllPosts() throws SQLException ,RecordNotFoundException;
}
