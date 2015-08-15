package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.dk.entities.Crew;

/**
 * Created by d.koshlyak on 06.08.2015.
 */
@Transactional
@Repository
public interface CrewRepository extends JpaRepository<Crew,Long> {
    Crew findByCrewName(String crewName);
}
