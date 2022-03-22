package co.edu.usbcali.projectmanager.business.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

import co.edu.usbcali.projectmanager.business.implement.ActivityServiceImpl;
import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.repository.ActivityRepository;
import co.edu.usbcali.projectmanager.repository.StateActivityRepository;
import co.edu.usbcali.projectmanager.test.IDataModelUtilTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ActivityServiceTest implements IDataModelUtilTest {

	private ActivityServiceImpl activityServiceImpl;

	@Mock
	private ActivityRepository activityRepository;

	@Mock
	private IProjectService projectService;

	@Mock
	private StateActivityRepository stateActivityRepository;

	@BeforeEach
	public void setUp() {
		activityServiceImpl = new ActivityServiceImpl();
		ReflectionTestUtils.setField(activityServiceImpl, "activityRepository", activityRepository);
		ReflectionTestUtils.setField(activityServiceImpl, "projectService", projectService);
		ReflectionTestUtils.setField(activityServiceImpl, "stateActivityRepository", stateActivityRepository);

	}

	@Test
	@DisplayName("Test createActivity")
	@Order(1)
	void createActivityTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		Mockito.doReturn(builProjectResponse()).when(projectService).findByProjectId(Mockito.any());
		assertDoesNotThrow(() -> activityServiceImpl.createActivity(buildActivityRequest(stateActivity)));
	}
	
	@Test
	@DisplayName("Test findActivitiesByProject")
	@Order(2)
	void findActivitiesByProjectTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		Mockito.doReturn(buildActivityPage(stateActivity)).when(activityRepository).findActivitiesByProjectId(Mockito.any(), Mockito.any());
		assertDoesNotThrow(() -> activityServiceImpl.findActivitiesByProject(Mockito.any(), Mockito.any()));
	}
	
	@Test
	@DisplayName("Test findActivityById")
	@Order(3)
	void findActivityByIdTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		Mockito.doReturn(buildActivity(stateActivity)).when(activityRepository).findByActivityId(Mockito.any());
		assertDoesNotThrow(() -> activityServiceImpl.findActivityById(Mockito.any()));
	}
	
	@Test
	@DisplayName("Test updateActivity")
	@Order(4)
	void updateActivityTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		Mockito.doReturn(buildActivity(stateActivity)).when(activityRepository).findByActivityId(Mockito.any());
		assertDoesNotThrow(() -> activityServiceImpl.updateActivity(Mockito.any()));
	}
	
	@Test
	@DisplayName("Test deleteActivity")
	@Order(5)
	void deleteActivityTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		Mockito.doReturn(buildActivity(stateActivity)).when(activityRepository).findByActivityId(Mockito.any());
		assertDoesNotThrow(() -> activityServiceImpl.deleteActivity(Mockito.any()));
	}
	
	

}
