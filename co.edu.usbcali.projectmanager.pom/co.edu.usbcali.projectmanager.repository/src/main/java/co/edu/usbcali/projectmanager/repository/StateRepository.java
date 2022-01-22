package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

	@Query(value = "SELECT state_id, state_name fROM public.state where state_id=?1 or state_id=?2 or state_id=?3 \n"
			+ "or state_id=?4 or state_id=?5", nativeQuery = true)
	public List<State> findAllStatesProjects(Long solini, Long decline, Long finished, Long progress,
			Long stateAavlaible);

}
