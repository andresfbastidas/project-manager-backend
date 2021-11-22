package co.edu.usbcali.projectmanager.business.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.UserApp;
import co.edu.usbcali.projectmanager.model.excepcion.ProjectManagerExcepcion;
import co.edu.usbcali.projectmanager.model.request.SignupRequest;
import co.edu.usbcali.projectmanager.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserApp user = userRepository.findByUsername(userName);
		if (user == null) {

		}

		return UserDetailsImpl.build(user);
	}

	public void registerUser(SignupRequest signupRequest) throws ProjectManagerExcepcion {
		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			throw new ProjectManagerExcepcion("", "", null, null, null);
		}

		// Create new user's account
		UserApp user = new UserApp();
		user.setUserName(signupRequest.getUsername());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(encoder.encode(signupRequest.getPassword()));
		user.setFirtsName(signupRequest.getFirstName());
		user.setSurname(signupRequest.getSurname());
		Profile profile = new Profile();
		profile.setProfileId(signupRequest.getIdProfile());
		user.setProfile(profile);

		userRepository.save(user);
	}

}
