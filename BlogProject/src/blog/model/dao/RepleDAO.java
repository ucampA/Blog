package blog.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import blog.model.dto.RepleBean;
import blog.util.DBUtil;

public class RepleDAO {
	public static int sendReple(RepleBean bean) {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.insert("Reple.insertReple", bean);
		} finally {
			session.close();
		}
	}

	public static List repleList(int pno) {
		SqlSession session = DBUtil.getSqlSession();
		try {
			return session.selectList("Reple.repleList", pno);
		} finally {
			session.close();
		}
	}

	public static int deleteReple(int rno) {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.delete("Reple.deleteReple", rno);
		} finally {
			session.close();
		}
	}

	public static int updateReple(RepleBean bean) {
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			return session.update("Reple.updateReple", bean);
		} finally {
			session.close();
		}
	}
}
