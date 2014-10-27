package blog.service;

import java.sql.SQLException;
import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dao.PostDAO;
import blog.model.dto.PostBean;

public class BlogManagerment implements BlogManagermentIF{
	private static BlogManagerment instance = new BlogManagerment();
	public static BlogManagerment getInstance(){
		return instance;
	}
	
	public List<PostBean> selectAll() throws SQLException ,RecordNotFoundException{
		List<PostBean> list = null;
		try {
			list = PostDAO.selectAll();
			if(list == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return list;
	}

	public List<PostBean> selectAllPosts(String userid) throws SQLException ,RecordNotFoundException{
		List<PostBean> list = null;
		try {
			list = PostDAO.selectAllPosts(userid);
			if(list == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return list;
	}
	
	public PostBean selectPostByNo(int no) throws SQLException ,RecordNotFoundException{
		PostBean blog = null;
		try {
			blog = PostDAO.selectPostByNo(no);
			if(blog == null){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
		return blog;
	}
	
	public void insertPost(PostBean post) throws SQLException{
		int result = 0;
		try {
			result = PostDAO.insertPost(post);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void updatePost(PostBean post) throws SQLException{
		int result = 0;
		try {
			result = PostDAO.updatePost(post);
			if(result == 0){
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public int updateReadCount(int pno) throws SQLException ,RecordNotFoundException{
		int result = 0;
		try {
			result = PostDAO.updateReadCount(pno);
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
			result = PostDAO.deletePostByNo(branchNo);
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
			result = PostDAO.deleteAllPosts();
			if(result == 0){
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public Object selectBlogNameByID(String userid) {
		return null;
	}
}
