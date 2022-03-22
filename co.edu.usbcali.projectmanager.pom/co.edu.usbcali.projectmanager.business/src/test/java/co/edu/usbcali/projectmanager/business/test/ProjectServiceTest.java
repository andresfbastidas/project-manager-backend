package co.edu.usbcali.projectmanager.business.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import co.edu.usbcali.projectmanager.business.implement.ProjectServiceImpl;
import co.edu.usbcali.projectmanager.business.implement.UserDetailsServiceImpl;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.repository.ProjectDeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProjectListRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRequestRepository;
import co.edu.usbcali.projectmanager.repository.ProjectUserDirectorNameRepository;
import co.edu.usbcali.projectmanager.repository.ProjectUserRepository;
import co.edu.usbcali.projectmanager.test.IDataModelUtilTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProjectServiceTest implements IDataModelUtilTest {

	private ProjectServiceImpl projectServiceImpl;

	@Mock
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Mock
	private ProjectRepository projectRepository;

	@Mock
	private ProjectDeliveryRepository projectDeliveryRepository;

	@Mock
	private ProjectUserRepository projectUserRepository;

	@Mock
	private ProjectRequestRepository projectRequestRepository;

	@Mock
	private ProjectListRepository projectListRepository;

	@Mock
	private ProjectUserDirectorNameRepository projectUserDirectorNameRepository;

	@BeforeEach
	public void setUp() {

		projectServiceImpl = new ProjectServiceImpl();

		ReflectionTestUtils.setField(projectServiceImpl, "userDetailsServiceImpl", userDetailsServiceImpl);
		ReflectionTestUtils.setField(projectServiceImpl, "projectRepository", projectRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectDeliveryRepository", projectDeliveryRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectUserRepository", projectUserRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectRequestRepository", projectRequestRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectListRepository", projectListRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectUserDirectorNameRepository",
				projectUserDirectorNameRepository);
	}

	@Test
	@DisplayName("Test create project by state progress and avalaible")
	@Order(1)
	void createProjectTest() throws ProjectManagementException {
		Mockito.doReturn(buildUserApp()).when(userDetailsServiceImpl).findByUserName(Mockito.any());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectDeliveryRepository.saveAndFlush(any(ProjectDelivery.class))).thenReturn(buildProjectDelivery());
		Mockito.doReturn(buildProject()).when(projectRepository).findByProjectId(Mockito.any());
		CreateProjectRequest createProjectRequest = buildProjectCreateRequest();
		assertDoesNotThrow(() -> projectServiceImpl.createProject(createProjectRequest));

	}

	@Test
	@DisplayName("Test create project by state solini")
	@Order(2)
	void createProjectSoliniTest() throws ProjectManagementException {
		Mockito.doReturn(buildUserApp()).when(userDetailsServiceImpl).findByUserName(Mockito.any());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectRequestRepository.save(any(ProjectRequest.class))).thenReturn(buildProjectRequest());
		Mockito.doReturn(buildProject()).when(projectRepository).findByProjectId(Mockito.any());
		CreateProjectRequest createProjectRequest = buildProjectCreateRequest();
		assertDoesNotThrow(() -> projectServiceImpl.createProject(createProjectRequest));

	}

	@Test
	@DisplayName("Test findAllProjectByState")
	@Order(3)
	void findAllProjectByStateTest() throws ProjectManagementException {
		Mockito.when(projectListRepository.findAllByProjectState(Mockito.any(), Mockito.any()))
				.thenReturn(buildProjectsPageListDTO());
		assertDoesNotThrow(() -> projectServiceImpl.findAllProjectByState(Mockito.any(), Mockito.any()));

	}

	@Test
	@DisplayName("Test findProjectDTO")
	@Order(4)
	void findProjectDTOTest() throws ProjectManagementException {
		Mockito.when(projectListRepository.findProjectDTO(Mockito.any())).thenReturn(buildProjectsListDTO());
		assertDoesNotThrow(() -> projectServiceImpl.findProjectDTO(Mockito.any()));

	}

	@Test
	@DisplayName("Test findAllProjectsByUserName")
	@Order(5)
	void findAllProjectsByUserNameTest() throws ProjectManagementException {
		Mockito.doReturn(buildProjectUserDirectorNameDTOPage()).when(projectUserDirectorNameRepository)
				.findAllProjectsByUserNameDTO(any(Pageable.class), any(Long.class), any(String.class));
		int numPage = 0;
		int size = 10;
		Pageable paging = PageRequest.of(numPage, size);
		assertDoesNotThrow(() -> projectServiceImpl.findAllProjectsByUserName(paging, ("andres.bastidas")));

	}

}
