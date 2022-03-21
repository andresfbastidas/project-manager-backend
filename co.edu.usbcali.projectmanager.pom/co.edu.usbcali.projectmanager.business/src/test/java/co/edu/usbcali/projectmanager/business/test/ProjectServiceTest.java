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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import co.edu.usbcali.projectmanager.business.implement.ProjectServiceImpl;
import co.edu.usbcali.projectmanager.business.implement.UserDetailsServiceImpl;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.repository.ProjectDeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRepository;
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

	@BeforeEach
	public void setUp() {

		projectServiceImpl = new ProjectServiceImpl();

		ReflectionTestUtils.setField(projectServiceImpl, "userDetailsServiceImpl", userDetailsServiceImpl);
		ReflectionTestUtils.setField(projectServiceImpl, "projectRepository", projectRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectDeliveryRepository", projectDeliveryRepository);
		ReflectionTestUtils.setField(projectServiceImpl, "projectUserRepository", projectUserRepository);
	}

	@Test
	@DisplayName("Test create project")
	@Order(1)
	void createProject() throws ProjectManagementException {
		Mockito.doReturn(buildUserApp()).when(userDetailsServiceImpl).findByUserName(Mockito.any());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectRepository.saveAndFlush(any(Project.class))).thenReturn(buildProject());
		when(projectDeliveryRepository.saveAndFlush(any(ProjectDelivery.class))).thenReturn(buildProjectDelivery());
		Mockito.doReturn(buildProject()).when(projectRepository).findByProjectId(Mockito.any());
		CreateProjectRequest createProjectRequest = buildProjectRequets();
		assertDoesNotThrow(() -> projectServiceImpl.createProject(createProjectRequest));

	}

}
