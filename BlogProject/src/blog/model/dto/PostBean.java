package blog.model.dto;
//jaesung -1018-1:20
public class PostBean {
	private int no;
	private String title;
	private String content;
	private String writeday;
	private int readcount;
	private String userid;
	
	public PostBean() {
		super();
	}
	public PostBean(String title, String content, String userid) {
		super();
		this.title = title;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlogBean [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
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