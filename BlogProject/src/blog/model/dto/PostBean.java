package blog.model.dto;
//jaesung -1018-1:20
public class PostBean {
	private int no;
	private String title;
	private String content;
	private String writeday;
	private int readcount;
	private String userid;
	private String openState;
	
	public PostBean() {
		super();
	}
	public PostBean(int no, String title, String content, String openState) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.openState = openState;
	}
	public PostBean(String title, String content, String userid, String openState) {
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.openState = openState;
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
	public String getOpenState() {
		return openState;
	}
	public void setOpenState(String openState) {
		this.openState = openState;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostBean [no=");
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
		builder.append(", openState=");
		builder.append(openState);
		builder.append("]");
		return builder.toString();
	}
}
