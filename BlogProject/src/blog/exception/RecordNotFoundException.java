package blog.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		super();
	}
	
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
