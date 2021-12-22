package co.edu.usbcali.projectmanager.fcd.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.implement.UserDetailsServiceImpl;
import co.edu.usbcali.projectmanager.fcd.security.JwtUtils;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dao.UserDetailsDAO;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.LoginRequest;
import co.edu.usbcali.projectmanager.model.request.SignupRequest;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.JwtResponse;
import co.edu.usbcali.projectmanager.model.response.UserNameResponse;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;

@RestController
@RequestMapping(path = FcdConstants.USER)
@CrossOrigin(origins = "${cross.origin}")
public class UserAppController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsServiceImpl userServiceImpl;

	@PostMapping(path = FcdConstants.LOGIN, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsDAO userDetails = (UserDetailsDAO) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping(path = FcdConstants.CREATE_USER, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest)
			throws ProjectManagementException {

		userServiceImpl.registerUser(signUpRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_CREATE_USER);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FIND_USER_NAME)
	@ResponseBody
	public ResponseEntity<?> findUserName(@Valid @PathVariable String userName) throws ProjectManagementException {

		UserNameResponse userNameResponse = userServiceImpl.findByUserName(userName);
		return new ResponseEntity<>(userNameResponse, HttpStatus.OK);
	}
	
	@GetMapping(path = FcdConstants.FINDALL_USERS_PROFILE)
	@ResponseBody
	public ResponseEntity<?> findAllUsersProfile() throws ProjectManagementException {

		GenericListResponse<Userapp> usersProfileListResponse = userServiceImpl.findAllUsersProfile();
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}

}
