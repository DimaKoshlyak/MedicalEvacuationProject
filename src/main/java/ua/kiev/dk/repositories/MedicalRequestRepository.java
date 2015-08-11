package ua.kiev.dk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.dk.entities.MedicalRequest;

import java.util.List;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
public interface MedicalRequestRepository extends JpaRepository<MedicalRequest,Long> {
    List<MedicalRequest> findByActiveRequest(boolean isActiveRequest);
}
