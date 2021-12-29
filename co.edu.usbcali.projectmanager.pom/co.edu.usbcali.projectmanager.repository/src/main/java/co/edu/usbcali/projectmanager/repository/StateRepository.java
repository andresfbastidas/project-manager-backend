package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

	@Query(value = "SELECT state_id, state_name\n"
			+ "	FROM public.state where state_id=?1 or state_id=?2", nativeQuery = true)
	public List<State> findStatesProjectDirector(Long stateProgress, Long stateAavlaible);
	
	@Query(value = "SELECT state_id, state_name\n"
			+ "	FROM public.state where state_id=?1", nativeQuery = true)
	public List<State> findStatesProjectStudent(Long stateSolini);
}
