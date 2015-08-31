package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.dk.entities.MedicalRequest;

import java.util.List;

public interface MedicalRequestRepository extends JpaRepository<MedicalRequest, Long> {
    List<MedicalRequest> findByActiveRequest(boolean isActiveRequest);

    List<MedicalRequest> findByUnitLastNameLike(String pattern);
}
