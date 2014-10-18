package blog.model.dto;

public class MemberBean {
	String userid;
	String userpw;
	String name;
	String phone;
	String blogname;
	char type;
	
	public MemberBean() { }
	public MemberBean(String userid, String userpw, String name, String phone,
			String blogname, char type) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.phone = phone;
		this.blogname = blogname;
		this.type = type;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [userid=");
		builder.append(userid);
		builder.append(", userpw=");
		builder.append(userpw);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", blogname=");
		builder.append(blogname);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
}
