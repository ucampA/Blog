package blog.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import blog.model.dto.BlogBean;
import blog.util.DBUtil;

public class BlogDAO {
	public static List<BlogBean> selectAllPosts(String userid) throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectList("Blog.selectAllPosts", userid);
		} finally {
			session.close();
		}
	}
	
	public static BlogBean selectPostByNo(int no) throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectOne("Blog.selectPostByNo", no);
		} finally {
			session.close();
		}
	}
	
	public static int insertPost(BlogBean post) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.insert("Blog.insertPost", post);
		} finally {
			session.close();
		}
	}
	
	public static int updatePost(BlogBean post) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Blog.updatePost", post);
		} finally {
			session.close();
		}
	}
	
	public static int updateReadCount() throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Blog.updateReadCount");
		} finally {
			session.close();
		}
	}
	
	public static int deletePostByNo(int branchNo) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.delete("Blog.deletePostByNo", branchNo);
		} finally {
			session.close();
		}
	}
	
	public static int deleteAllPosts() throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.delete("Blog.deleteAllPosts");
		} finally {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
