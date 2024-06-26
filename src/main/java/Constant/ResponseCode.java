package Constant;

import java.util.Arrays;
import java.util.Optional;
//for message and for login authentication
public enum ResponseCode {
	
	SUCCESS(200, "OK"),
    FAILURE(422, "Unprocessible Entity, Failed to Process"),
    NO_CONTENT(204, "No Items Found"),
    PAGE_NOT_FOUND(404, "The Page You are Searching For is Not available"),
    ACCESS_DENIED(403, "Please Login First to continue"),
    BAD_REQUEST(400, "Bad Request, Please Try Again"),
    UNAUTHORIZED(401,"Invalid Credentials, Try Again"),
    SESSION_EXPIRED(401, "Session Expired, Login Again to Continue"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error, Try Again!!"),
    DATABASE_CONNECTION_FAILURE(406,"Unable to Connect to DB, Please Check your db credentials in application.properties"),
    METHOD_NOT_ALLOWED(405, "Requested HTTP method is not supported by this URL"),;
	
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
	
	
	
	// Reverse lookup methods
    public static Optional<ResponseCode> getMessageByStatusCode(int statusCode) {
        return Arrays.stream(ResponseCode.values())
                .filter(error -> error.getCode() == statusCode)
                .findFirst();
    }

}
