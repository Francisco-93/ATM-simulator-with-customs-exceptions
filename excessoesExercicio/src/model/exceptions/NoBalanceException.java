package model.exceptions;

public class NoBalanceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NoBalanceException(String msg) {
		super(msg);
	}
}
