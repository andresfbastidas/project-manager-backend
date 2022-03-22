package co.edu.usbcali.projectmanager.business.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import co.edu.usbcali.projectmanager.business.implement.UserDetailsServiceImpl;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.repository.UserAppRepository;
import co.edu.usbcali.projectmanager.test.IDataModelUtilTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserDetailsServiceTest implements IDataModelUtilTest {

	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Mock
	private UserAppRepository userAppRepository;

	@Mock
	private PasswordEncoder encoder;

	@BeforeEach
	public void setUp() {
		userDetailsServiceImpl = new UserDetailsServiceImpl();
		ReflectionTestUtils.setField(userDetailsServiceImpl, "userAppRepository", userAppRepository);
		ReflectionTestUtils.setField(userDetailsServiceImpl, "encoder", encoder);

	}

	@Test
	@DisplayName("Test loadUserByUsername")
	@Order(1)
	void loadUserByUsernameTest() throws ProjectManagementException {
		Mockito.doReturn(buildUserApp()).when(userAppRepository).findByUserName(Mockito.any());
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(Mockito.any());
		assertNotNull(userDetails);
	}

	@Test
	@DisplayName("Test findByUserName")
	@Order(2)
	void findByUserNameTest() throws ProjectManagementException {
		Mockito.doReturn(buildUserApp()).when(userAppRepository).findByUserName(Mockito.any());
		Userapp userapp = userDetailsServiceImpl.findByUserName(Mockito.any());
		assertNotNull(userapp);
	}

	@Test
	@DisplayName("Test registerUser fail")
	@Order(3)
	void registerUserTestFail() throws ProjectManagementException {
		boolean exists = true;
		Mockito.doReturn(exists).when(userAppRepository).existsByUserName(Mockito.any());
		assertThrows(ProjectManagementException.class,
				() -> userDetailsServiceImpl.registerUser(buildSignupRequest()));
	}

	@Test
	@DisplayName("Test registerUser Succes")
	@Order(4)
	void registerUserTestSuccess() throws ProjectManagementException {
		boolean exists = false;
		String passwordEncode = "wjdwqkjedbe";
		Mockito.doReturn(exists).when(userAppRepository).existsByUserName(Mockito.any());
		Mockito.doReturn(passwordEncode).when(encoder).encode(Mockito.any());
		assertDoesNotThrow(() -> userDetailsServiceImpl.registerUser(buildSignupRequest()));
	}

	@Test
	@DisplayName("Test updateUser")
	@Order(5)
	void updateUserTest() throws ProjectManagementException {
		String passwordEncode = "wjdwqkjedbe";
		Mockito.doReturn(buildUserApp()).when(userAppRepository).findByUserName(Mockito.any());
		Mockito.doReturn(passwordEncode).when(encoder).encode(Mockito.any());
		when(userAppRepository.save(any(Userapp.class))).thenReturn(buildUserApp());
		assertDoesNotThrow(() -> userDetailsServiceImpl.updateUser(buildSignupRequest()));
	}

	@Test
	@DisplayName("Test deleteUser")
	@Order(6)
	void deleteUserTest() throws ProjectManagementException {
		Mockito.doReturn(buildUserApp()).when(userAppRepository).findByUserName(Mockito.any());
		assertDoesNotThrow(() -> userDetailsServiceImpl.updateUser(buildSignupRequest()));
	}

}
