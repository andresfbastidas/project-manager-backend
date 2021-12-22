package co.edu.usbcali.projectmanager.model.constant;

public class FcdConstants {

	private static final String VERSION_API = "1.0";

	public static final String CONTEXT_API = "/api/" + VERSION_API;

	public static final String PROJECT = CONTEXT_API + "/project";
	
	public static final String ACTIVITY = CONTEXT_API + "/activity";

	public static final String USER = CONTEXT_API + "/user";
	
	public static final String GENERIC_LIST = CONTEXT_API + "/genericList";

	public static final String CREATE_PROJECT = "/createProject";
	
	public static final String ASSOCIATED_PROJECT_USER = "/associatedProjectUser";
	
	public static final String CREATE_ACTIVITY = "/createActivity";

	public static final String LOGIN = "/authenticate";

	public static final String CREATE_USER = "/createUser";
	
	public static final String FIND_USER_NAME = "/findByUserName/{userName}";
	
	public static final String FINDALL_USERS_PROFILE = "/findAllUsersProfile";
	
	public static final String FINDALL_DELIVERYS = "/findAllDeliverys";
	
	public static final String FINDALL_RESEARCH_TYPOLOGYS = "/findAllResearchTypologys";
	
	public static final String FINDALL_STATES = "/findAllStates";

}
