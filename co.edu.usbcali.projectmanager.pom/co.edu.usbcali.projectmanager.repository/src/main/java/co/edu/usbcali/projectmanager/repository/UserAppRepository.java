package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Userapp;

@Repository
public interface UserAppRepository extends JpaRepository<Userapp, Long> {

	public Userapp findByUserName(String userName);
	
	public Boolean existsByUserName(String userName);
}
