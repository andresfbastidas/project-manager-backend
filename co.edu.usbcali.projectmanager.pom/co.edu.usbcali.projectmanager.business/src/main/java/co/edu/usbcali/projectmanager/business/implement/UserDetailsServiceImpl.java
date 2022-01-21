package co.edu.usbcali.projectmanager.business.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.usbcali.projectmanager.business.interfaces.IUserService;
import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dao.UserDetailsDAO;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.SignupRequest;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;
import co.edu.usbcali.projectmanager.model.response.UserNameResponse;
import co.edu.usbcali.projectmanager.repository.UserAppRepository;

@Service
public class UserDetailsServiceImpl extends ServiceUtils implements UserDetailsService, IUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private static final String CLASS_NAME = "UserDetailsServiceImpl";

	@Autowired
	private UserAppRepository userAppRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws BadCredentialsException {
		Userapp user = null;
		try {
			user = userAppRepository.findByUserName(userName);
			if (user == null) {
				throw new BadCredentialsException(KeyConstants.USER_NOT_FOUND);
			}
		} catch (BadCredentialsException e) {
			throw e;
		}

		return UserDetailsDAO.build(user);
	}

	@Transactional
	public UserNameResponse findByUserName(String userName) throws ProjectManagementException {
		Userapp userApp = null;
		UserNameResponse userNameResponse = null;
		try {
			userApp = userAppRepository.findByUserName(userName);
			if (userApp == null) {
				buildCustomException(KeyConstants.USER_NOT_FOUND, KeyConstants.ERROR_CODE_USER_NOT_EXISTS);
			}
			userNameResponse = new UserNameResponse();
			userNameResponse.setUserapp(userApp);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

		return userNameResponse;
	}

	public GenericListResponse<Userapp> findAllUsersProfile() throws ProjectManagementException {
		List<Userapp> userapps = null;
		GenericListResponse<Userapp> usersProfileListResponse = null;
		try {
			usersProfileListResponse = new GenericListResponse<Userapp>();
			userapps = userAppRepository.findAllDirectorsRol(KeyConstants.ROL_DIRECTORID);

			if (userapps.isEmpty() || userapps == null) {
				buildCustomException(KeyConstants.USERS_LIST_EMPTY, KeyConstants.ERROR_CODE_LIST_USERS_EMPTY);
			}
			usersProfileListResponse.setGenericList(userapps);

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return usersProfileListResponse;

	}

	@Transactional
	public void registerUser(SignupRequest signupRequest) throws ProjectManagementException {
		try {
			if (userAppRepository.existsByUserName(signupRequest.getUserapp().getUserName())) {
				buildCustomException(KeyConstants.USER_EXISTS, KeyConstants.ERROR_CODE_EXISTS_USER);
			}

			Userapp user = new Userapp();
			user.setUserName(signupRequest.getUserapp().getUserName());
			user.setEmail(signupRequest.getUserapp().getEmail());
			user.setPassword(encoder.encode(signupRequest.getUserapp().getPassword()));
			user.setFirstName(signupRequest.getUserapp().getFirstName());
			user.setSurname(signupRequest.getUserapp().getSurname());
			user.setSecondName(signupRequest.getUserapp().getSecondName());
			user.setSecondSurname(signupRequest.getUserapp().getSecondSurname());
			Profile profile = new Profile();
			profile.setProfileId(signupRequest.getUserapp().getProfile().getProfileId());
			user.setProfile(profile);

			userAppRepository.save(user);

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	public void updateUser(SignupRequest signupRequest) throws ProjectManagementException {
		UserNameResponse userNameResponse = null;
		try {
			userNameResponse = this.findByUserName(signupRequest.getUserapp().getUserName());
			Userapp user = new Userapp();
			user.setUserName(userNameResponse.getUserapp().getUserName());
			user.setEmail(signupRequest.getUserapp().getEmail());
			user.setPassword(encoder.encode(signupRequest.getUserapp().getPassword()));
			user.setFirstName(signupRequest.getUserapp().getFirstName());
			user.setSurname(signupRequest.getUserapp().getSurname());
			user.setSecondName(signupRequest.getUserapp().getSecondName());
			user.setSecondSurname(signupRequest.getUserapp().getSecondSurname());
			Profile profile = new Profile();
			profile.setProfileId(signupRequest.getUserapp().getProfile().getProfileId());
			user.setProfile(profile);
			userAppRepository.save(user);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	public void deleteUser(String userName) throws ProjectManagementException {
		UserNameResponse userNameResponse = null;
		try {
			userNameResponse = this.findByUserName(userName);

			userAppRepository.delete(userNameResponse.getUserapp());
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

}
