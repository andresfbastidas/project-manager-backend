package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;

public interface ResearchTyplogyRepository extends JpaRepository<ResearchTypology, Long> {

	@Query(value = "SELECT * FROM research_typology", nativeQuery = true)
	public List<ResearchTypology> findAllResearchTypologiesList();
}
