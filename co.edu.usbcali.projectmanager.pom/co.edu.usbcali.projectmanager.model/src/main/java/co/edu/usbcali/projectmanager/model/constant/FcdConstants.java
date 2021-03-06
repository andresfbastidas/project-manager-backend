package co.edu.usbcali.projectmanager.model.constant;

public class FcdConstants {

	private static final String VERSION_API = "1.0";

	public static final String CONTEXT_API = "/api/" + VERSION_API;

	public static final String PROJECT = CONTEXT_API + "/project";
	
	public static final String ACTIVITY = CONTEXT_API + "/activity";
	
	public static final String COMMENT = CONTEXT_API + "/comment";

	public static final String USER = CONTEXT_API + "/user";
	
	public static final String GENERIC_LIST = CONTEXT_API + "/genericList";

	public static final String CREATE_PROJECT = "/createProject";
	
	public static final String ASSOCIATED_PROJECT_USER = "/associatedProjectUser";
	
	public static final String CREATE_ACTIVITY = "/createActivity";
	
	public static final String NEW_COMMENT = "/newComment";
	
	public static final String FIND_ALL_COMMENTS_BY_ACTIVITY = "/findCommentsByActivity/";

	public static final String LOGIN = "/authenticate";

	public static final String CREATE_USER = "/createUser";
	
	public static final String FIND_USER_NAME = "/findByUserName/";
	
	public static final String UPDATE_USER = "/updateUser";
	
	public static final String DELETE_USER = "/deleteUser";
	
	public static final String FINDALL_USERS_PROFILE = "/findAllUsersProfile";
	
	public static final String FINDALL_DELIVERYS = "/findAllDeliverys";
	
	public static final String FINDALL_RESEARCH_TYPOLOGYS = "/findAllResearchTypologys";
	
	public static final String FIND_ALL_STATES_PROJECTS = "/findAllStatesProjects/";
	
	public static final String FINDALL_PROFILES = "/findAllProfiles";
	
	public static final String FINDALL_STATE_PROJECT_REQUEST = "/findAllStateProjectRequest";
	
	public static final String FINDALL_PROJECTS_BY_STATE = "/findAllProjectsState/";
	
	public static final String FIND_PROJECT_DTO = "/findProjectDTO/";
	
	public static final String FINDALL_PROJECTS_BY_USER_NAME = "/findAllProjectsByUserName/";
	
	public static final String FINDALL_ACTIVITIES_BY_PROJECT = "/findAllActivitiesByProject/";
	
	public static final String FINDALL_STATES_ACTIVITIES = "/findAllStatesActivities";
	
	public static final String FINDALL_USERS_BY_PROJECT = "/findAllUsersByProject/";
	
	public static final String FINDALL_PROJECT_REQUEST_BY_STATE = "/findByProjectRequestState/";
	
	public static final String FINDALL_PROJECT_REQUEST_BY_STATE_USER = "/findByProjectRequestStateUser/";
	
	public static final String FIND_PROJECT_BY_ID = "/findProjectById/";
	
	public static final String APPROVAL_PROJECTS = "/approvalProjects";
	
	public static final String UPDATE_PROJECT_PROJECT_REQUEST = "/updateProjectAndprojectRequest";
	
	public static final String UPDATE_PROJECT= "/updateProject";
	
	public static final String UPDATE_ACTIVITY= "/updateActivity";
	
	public static final String UPDATE_COMMENT= "/updateComment";
	
	public static final String DELETE_ACTIVITY= "/deleteActivity";
	
	public static final String DELETE_COMMENT= "/deleteComment";
	
	public static final String DECLINE_PROJECTS = "/declineProjects";

}
