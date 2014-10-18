package blog.service;

import java.sql.SQLException;
import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dao.BlogDAO;
import blog.model.dto.BlogBean;

public class BlogManagerment implements BlogManagermentIF{
	private static BlogManagerment instance = new BlogManagerment();
	public static BlogManagerment getInstance(){
		return instance;
	}
	//Å×½ºÆ®?¤»¤»
	public List<BlogBean> selectAllBranches() throws SQLException ,RecordNotFoundException{
		List<BlogBean> list = null;
		try {
			list = BlogDAO.selectAllBranches();
			if(list == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return list;
	}
	
	public BlogBean selectPostByNo(int no) throws SQLException ,RecordNotFoundException{
		BlogBean blog = null;
		try {
			blog = BlogDAO.selectPostByNo(no);
			if(blog == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return blog;
	}
	
	public void insertPost(BlogBean post) throws SQLException{
		int result = 0;
		try {
			result = BlogDAO.insertPost(post);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void updatePost(BlogBean post) throws SQLException{
		int result = 0;
		try {
			result = BlogDAO.updatePost(post);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public int updateReadCount() throws SQLException ,RecordNotFoundException{
		int result = 0;
		try {
			result = BlogDAO.updateReadCount();
			if(result == 0){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}
	
	public void deletePostByNo(int branchNo) throws SQLException ,RecordNotFoundException{
		int result = 0;
		try {
			result = BlogDAO.deletePostByNo(branchNo);
			if(result == 0){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void deleteAllPosts() throws SQLException ,RecordNotFoundException{
		int result = 0;
		try {
			result = BlogDAO.deleteAllPosts();
			if(result == 0){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}
