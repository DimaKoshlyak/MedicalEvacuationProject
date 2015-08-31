package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.dk.entities.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Institution findByInstitutionName(String institutionName);


}
