package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.UserApp;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {

	public UserApp findByUserName(String userName);
	
	Boolean existsByUserName(String userName);
}
