package activities;

public class CustomException extends Exception {
	
	private String message;
	
	@Override
	public String getMessage() {
	    return message;
	}
	
	public CustomException(String message) {
		this.message = message;
	}

}
