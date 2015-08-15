package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.dk.entities.Institution;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
Institution findByInstitutionName(String institutionName);


}
