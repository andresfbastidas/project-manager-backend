package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value = "SELECT * FROM public.comment com where com.activity_id=?1", nativeQuery = true)
	public Page<Comment> findCommentsByActivityId(Pageable pageable, Long activityId);

	@Query(value = "SELECT *\n"
			+ "	FROM public.comment com where com.comment_id=?1", nativeQuery = true)
	public Comment findByCommentId(Long commentId);
}
