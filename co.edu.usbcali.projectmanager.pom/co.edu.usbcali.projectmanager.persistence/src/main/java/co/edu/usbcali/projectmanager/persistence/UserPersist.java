package co.edu.usbcali.projectmanager.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.User;

@Repository
public interface UserPersist extends JpaRepository<User, Long> {

}
