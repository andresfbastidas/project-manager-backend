package co.edu.usbcali.projectmanager.model.constant;

public class KeyConstants {

	// Mesagges Success
	public static final String SUCCESS_CREATE_PROJECT = "Proyecto creado con exito";
	public static final String SUCCESS_CREATE_USER = "Usuario creado con exito";
	public static final String SUCCESS_CREATE_ACTIVITY = "Actividad creada con exito";
	public static final String SUCCESS_ASSOCIATED_PROJECT_USER = "Usuario asociado";

	// Messages Errors
	public static final String USER_NOT_FOUND = "El usuario no existe";
	public static final String PROJECT_NOT_EXISTS = "El projecto no existe";
	public static final String USER_EXISTS = "El usuario ya se encuentra registrado";
	public static final String COMMON_ERROR = "Error inesperado en el aplicativo. clase [%s]";
	public static final String UNEXPECTED_ERROR = "Error inesperado en el aplicativo";
	public static final String PROJECT_NOT_SAVE = "No fue posible crear el proyecto";
	public static final String USERS_LIST_EMPTY = "La lista de usuarios se encuentra vacia";
	public static final String ERROR_ASSOCIATED_PROJECT_USER_EXISTS = "El usuario ya se encuentra asociado al proyecto";
	public static final String ERROR_ASSOCIATED_PROJECT_USER_PROFILE_DIRECTOR = "El proyecto no puede tener más de un director";
	public static final String GENERIC_LIST_EMPTY = "La lista generica se encuentra vacia";
	public static final String PROJECT_LIST_EMPTY = "El usuario no tiene proyectos asociados";
	public static final String ERROR_PROJECTUSER_ROL = "El usuario debe tener rol de director";
	
	// Error Codes
	public static final String ERROR_CODE_PROJECT_USER_ROL = "108";
	public static final String ERROR_CODE_PROJECT_LIST_EMPTY = "107";
	public static final String ERROR_CODE_GENERIC_LIST_EMPTY = "106";
	public static final String ERROR_CODE_LIST_USERS_EMPTY = "105";
	public static final String ERROR_CODE_ASSOCIATED_PROJECT_USER = "104";
	public static final String ERROR_CODE_PROJECT_NOT_SAVE = "104";
	public static final String ERROR_CODE_USER_NOT_EXISTS = "103";
	public static final String ERROR_CODE_PROJECT_NULL = "102";
	public static final String ERROR_CODE_EXISTS_USER = "101";
	public static final String UNEXPECTED_ERROR_CODE = "100";

	// Constants
	public static final Long DEFAULT_STATE = 1L;
	public static final Long AVALAIBLE_STATE = 5L;
	public static final String ROL_DIRECTOR = "DIRECTOR";
	public static final Long ROL_DIRECTORID = 1L;

}
