package Constant;

import java.util.Arrays;
import java.util.Optional;

public enum ResponseCode {
	
	SUCCES(200,"OK"), CLIENTERROR(400,"BAD REQUEST"),CLIENTERROR1(401,"UNAUTHORIZED");
	
	private final String messages;
	private final int code;
	
	private ResponseCode(int code,String messages) {
		this.messages = messages;
		this.code = code;
	}
	public String getMessages() {
		return messages;
	}
	public int getCode() {
		return code;
	}
	
	

}
