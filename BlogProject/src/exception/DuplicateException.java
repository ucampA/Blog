package exception;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super();
	}
	
	public DuplicateException(String msg) {
		super(msg);
	}
}
