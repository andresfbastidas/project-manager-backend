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
	public static final String ERROR_ASSOCIATED_PROJECT_USER_EXISTS = "El usuario ya se encuentra asociado al proyecto";
	// Error Codes
	public static final String ERROR_CODE_ASSOCIATED_PROJECT_USER = "104";
	public static final String ERROR_CODE_PROJECT_NOT_SAVE = "104";
	public static final String ERROR_CODE_USER_NOT_EXISTS = "103";
	public static final String ERROR_CODE_PROJECT_NULL = "102";
	public static final String ERROR_CODE_EXISTS_USER = "101";
	public static final String UNEXPECTED_ERROR_CODE = "100";

	// Constants
	public static final Long DEFAULT_STATE = 1L;

}
