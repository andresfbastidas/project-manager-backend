package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

	@Query(value = "SELECT * FROM state", nativeQuery = true)
	public List<State> findAllStates();
}
