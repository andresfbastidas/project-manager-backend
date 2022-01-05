package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	@Query(value = "SELECT * FROM profile", nativeQuery = true)
	public List<Profile> findAllProfiles();

}
