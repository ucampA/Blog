package blog.model.dto;

public class RepleBean {
	int rno;
	String content;
	String writeday;
	String userid;
	int pno;
	
	public RepleBean() { }
	public RepleBean(int rno, String content, String writeday, String userid, int pno) {
		super();
		this.rno = rno;
		this.content = content;
		this.writeday = writeday;
		this.userid = userid;
		this.pno = pno;
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RepleBean [rno=");
		builder.append(rno);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writeday=");
		builder.append(writeday);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", pno=");
		builder.append(pno);
		builder.append("]");
		return builder.toString();
	}
}
