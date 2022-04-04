package co.edu.usbcali.projectmanager.fcd.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.implement.UserDetailsServiceImpl;
import co.edu.usbcali.projectmanager.business.jwt.JwtUtils;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dao.UserDetailsDAO;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.LoginRequest;
import co.edu.usbcali.projectmanager.model.request.SignupRequest;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.JwtResponse;
import co.edu.usbcali.projectmanager.model.response.UserNameResponse;

@RestController
@RequestMapping(path = FcdConstants.USER)
@CrossOrigin(origins = "${projectmanager.allowedOriginsApps}")
public class UserAppController {

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsServiceImpl userServiceImpl;

	@PostMapping(path = FcdConstants.LOGIN, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws BadCredentialsException {

		Authentication authentication = userServiceImpl.validateUserNameAndPassword(loginRequest.getUsername(),
				loginRequest.getPassword());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsDAO userDetails = (UserDetailsDAO) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping(path = FcdConstants.CREATE_USER, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest)
			throws ProjectManagementException {

		userServiceImpl.registerUser(signUpRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_CREATE_USER);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FIND_USER_NAME + "{userName}")
	@ResponseBody
	public ResponseEntity<?> findUserName(@Valid @PathVariable String userName) throws ProjectManagementException {
		Userapp userapp = new Userapp();
		userapp = userServiceImpl.findByUserName(userName);
		UserNameResponse userNameResponse = new UserNameResponse();
		userNameResponse.setUserapp(userapp);
		return new ResponseEntity<>(userNameResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_USERS_PROFILE)
	@ResponseBody
	public ResponseEntity<?> findAllUsersProfile() throws ProjectManagementException {

		GenericListResponse<Userapp> usersProfileListResponse = userServiceImpl.findAllUsersProfile();
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}

	@PutMapping(path = FcdConstants.UPDATE_USER, consumes = "application/json")
	public ResponseEntity<?> updateUser(@RequestBody SignupRequest signupRequest) throws ProjectManagementException {
		userServiceImpl.updateUser(signupRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.UPDATE_USER);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@DeleteMapping(path = FcdConstants.DELETE_USER)
	public ResponseEntity<?> deleteUser(@RequestParam String userName) throws ProjectManagementException {
		userServiceImpl.deleteUser(userName);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.DELETE_USER);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

}
