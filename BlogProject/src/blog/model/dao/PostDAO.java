package blog.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import blog.model.dto.PostBean;
import blog.util.DBUtil;

public class PostDAO {
	
	public static List<PostBean> selectAll() throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectList("Post.selectAll");
		} finally {
			session.close();
		}
	}
	
	public static List<PostBean> selectAllPosts(String userid) throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectList("Post.selectAllPosts", userid);
		} finally {
			session.close();
		}
	}
	
	public static PostBean selectPostByNo(int no) throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectOne("Post.selectPostByNo", no);
		} finally {
			session.close();
		}
	}
	
	public static int insertPost(PostBean post) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.insert("Post.insertPost", post);
		} finally {
			session.close();
		}
	}
	
	public static int updatePost(PostBean post) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Post.updatePost", post);
		} finally {
			session.close();
		}
	}
	
	public static int updateReadCount(int pno) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Post.updateReadCount", pno);
		} finally {
			session.close();
		}
	}
	
	public static int deletePostByNo(int pno) throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.delete("Post.deletePostByNo", pno);
		} finally {
			session.close();
		}
	}
	
	public static int deleteAllPosts() throws SQLException {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.delete("Post.deleteAllPosts");
		} finally {
			session.close();
		}
	}
}
