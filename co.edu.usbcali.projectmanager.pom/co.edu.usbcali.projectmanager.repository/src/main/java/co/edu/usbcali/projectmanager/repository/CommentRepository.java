package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.projectmanager.model.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
