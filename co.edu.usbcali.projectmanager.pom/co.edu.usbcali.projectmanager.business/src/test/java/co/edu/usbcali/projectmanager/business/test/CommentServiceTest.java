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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import co.edu.usbcali.projectmanager.business.implement.CommentServiceImpl;
import co.edu.usbcali.projectmanager.business.interfaces.IActivityService;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.repository.CommentRepository;
import co.edu.usbcali.projectmanager.test.IDataModelUtilTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CommentServiceTest implements IDataModelUtilTest {

	private CommentServiceImpl commentServiceImpl;

	@Mock
	private CommentRepository commentRepository;

	@Mock
	private IActivityService activityService;

	@BeforeEach
	public void setUp() {
		commentServiceImpl = new CommentServiceImpl();
		ReflectionTestUtils.setField(commentServiceImpl, "commentRepository", commentRepository);
		ReflectionTestUtils.setField(commentServiceImpl, "activityService", activityService);

	}

	@Test
	@DisplayName("Test newComment")
	@Order(1)
	void newCommentTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		Mockito.doReturn(buildActivity(stateActivity)).when(activityService).findActivityById(Mockito.any());
		assertDoesNotThrow(() -> commentServiceImpl.newComment(buildCommentRequest()));
	}

	@Test
	@DisplayName("Test findCommentsByActivityId")
	@Order(2)
	void findCommentsByActivityIdTest() throws ProjectManagementException {
		Long stateActivity = 2L;
		int numPage = 0;
		int size = 10;
		Long activityId = 1L;
		Pageable paging = PageRequest.of(numPage, size);
		Mockito.doReturn(buildActivity(stateActivity)).when(activityService).findActivityById(Mockito.any());
		Mockito.doReturn(buildCommentPage()).when(commentRepository).findCommentsByActivityId(paging, activityId);
		assertDoesNotThrow(() -> commentServiceImpl.findCommentsByActivityId(paging, activityId));
	}

	@Test
	@DisplayName("Test updateComment")
	@Order(3)
	void updateCommentTest() throws ProjectManagementException {
		Mockito.doReturn(buildComment()).when(commentRepository).findByCommentId(Mockito.any());
		assertDoesNotThrow(() -> commentServiceImpl.updateComment(buildUpdateCommentRequest()));
	}

	@Test
	@DisplayName("Test deleteComment")
	@Order(4)
	void deleteCommentTest() throws ProjectManagementException {
		Mockito.doReturn(buildComment()).when(commentRepository).findByCommentId(Mockito.any());
		assertDoesNotThrow(() -> commentServiceImpl.deleteComment(Mockito.any()));
	}

}
