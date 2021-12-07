package co.edu.usbcali.projectmanager.business.implement;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dao.UserDetailsDAO;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.UserApp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.SignupRequest;
import co.edu.usbcali.projectmanager.repository.UserAppRepository;

@Service
public class UserDetailsServiceImpl extends ServiceUtils implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private static final String CLASS_NAME = "UserDetailsServiceImpl";

	@Autowired
	private UserAppRepository userAppRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws BadCredentialsException {
		UserApp user = null;
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
	public void registerUser(SignupRequest signupRequest) throws ProjectManagementException {
		try {
			if (userAppRepository.existsByUserName(signupRequest.getUsername())) {
				buildCustomException(KeyConstants.USER_EXISTS, KeyConstants.ERROR_CODE_EXISTS_USER);
			}

			UserApp user = new UserApp();
			user.setUserName(signupRequest.getUsername());
			user.setEmail(signupRequest.getEmail());
			user.setPassword(encoder.encode(signupRequest.getPassword()));
			user.setFirtsName(signupRequest.getFirstName());
			user.setSurname(signupRequest.getSurname());
			Profile profile = new Profile();
			profile.setProfileId(signupRequest.getIdProfile());
			user.setProfile(profile);

			userAppRepository.save(user);

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

}
