package co.edu.usbcali.projectmanager.business.interfaces;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;

import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.SignupRequest;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;

public interface IUserService {

	public UserDetails loadUserByUsername(String userName) throws BadCredentialsException;

	public Userapp findByUserName(String userName) throws ProjectManagementException;

	public GenericListResponse<Userapp> findAllUsersProfile() throws ProjectManagementException;

	public void registerUser(SignupRequest signupRequest) throws ProjectManagementException;

	public void updateUser(SignupRequest signupRequest) throws ProjectManagementException;

	public void deleteUser(String userName) throws ProjectManagementException;

}
