package co.edu.usbcali.projectmanager.business.implement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.repository.ProjectPersist;

@Service
public class ProjectServiceImpl implements IProjectService {

	private ProjectPersist projectPersist;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createProject(ProjectRequest projectRequest) throws ProjectManagementException, SQLException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			

			projectPersist.save(null);
		} catch (Exception e) {
			throw e;
		}

	}



}
