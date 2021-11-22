package co.edu.usbcali.projectmanager.fcd.constant;

public class FcdConstants {

	private static final String VERSION_API = "1.0";

	public static final String CONTEXT_API = "/api/" + VERSION_API;

	public static final String PROJECT = CONTEXT_API + "/project";
	
	public static final String USER = CONTEXT_API + "/user";
	
	public static final String CREATE_PROJECT = "/createProject";
	
	public static final String LOGIN = "/authenticate";
	
	public static final String CREATE_USER = "/createUser";

}
