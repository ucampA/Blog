package blog.model.dto;

public class BlogBean {
	String userid;
	String blogName;
	
	public BlogBean() { }
	public BlogBean(String userid, String blogName) {
		super();
		this.userid = userid;
		this.blogName = blogName;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlogBean [userid=");
		builder.append(userid);
		builder.append(", blogName=");
		builder.append(blogName);
		builder.append("]");
		return builder.toString();
	}
}
