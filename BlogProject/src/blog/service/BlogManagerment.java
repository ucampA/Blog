package blog.service;

import java.util.List;

import blog.exception.RecordNotFoundException;
import blog.model.dto.BlogBean;

public class BlogManagerment implements BlogManagermentIF{
	private static BlogManagerment instance = new BlogManagerment();
	public static BlogManagerment getInstance(){
		return instance;
	}
	
	public List<BlogBean> selectAllBranches() throws RecordNotFoundException{
		List<BlogBean> list = null;
		return list;
	}
}
