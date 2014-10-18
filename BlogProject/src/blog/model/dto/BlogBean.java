package blog.model.dto;
/*
 * no number(5) primary key,
	title varchar(50) not null,
	content varchar(500) not null,
	wirteday date not null,
	readcount number(4) not null,
	userid	varchar(20),
	constraint blog_userid_fk foreign key(userid) references member(userid)
);*/
public class BlogBean {
	private int no;
	private String title;
	private String writeday;
	private int readcount;
	private String userid;
	
	public BlogBean() {
		super();
	}
	public BlogBean(int no, String title, String writeday, int readcount,
			String userid) {
		super();
		this.no = no;
		this.title = title;
		this.writeday = writeday;
		this.readcount = readcount;
		this.userid = userid;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlogBean [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", writeday=");
		builder.append(writeday);
		builder.append(", readcount=");
		builder.append(readcount);
		builder.append(", userid=");
		builder.append(userid);
		builder.append("]");
		return builder.toString();
	}
}
