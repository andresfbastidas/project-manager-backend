package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Userapp;

@Repository
public interface UserAppRepository extends JpaRepository<Userapp, Long> {

	public Userapp findByUserName(String userName);
	
	public Boolean existsByUserName(String userName);
	
	@Query(value = "select * from public.userapp usr INNER JOIN public.profile p ON usr.profile_id = p.profile_id\n"
			+ "and p.profile_id = ?1", nativeQuery = true)
	public List<Userapp> findAllDirectorsRol(Long profileId);
}
