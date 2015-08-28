package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.MedicalRequest;
import ua.kiev.dk.repositories.MedicalRequestRepository;

import java.util.List;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
@Service("medicalRequestManager")
public class MedicalRequestManagerImpl implements MedicalRequestManager {

    @Autowired
    private MedicalRequestRepository medicalRequestRepository;

    @Override
    public List<MedicalRequest> listActiveMedicalRequests() {
        return medicalRequestRepository.findByActiveRequest(true);
    }

    @Override
    public List<MedicalRequest> listArchiveRequests() {
        return medicalRequestRepository.findByActiveRequest(false);
    }

    @Override
    public List<MedicalRequest> listByLastName(String pattern) {
        return medicalRequestRepository.findByUnitLastNameLike(pattern);
    }

    @Override
    public void moveToArchive(long id) {
        MedicalRequest medicalRequest = medicalRequestRepository.findOne(id);
        medicalRequest.setActiveRequest(false);
        medicalRequestRepository.save(medicalRequest);
    }

    @Override
    public MedicalRequest showAllInfoAboutRequest(long id) {
        MedicalRequest medicalRequest = medicalRequestRepository.findOne(id);
        return medicalRequest;
    }

    @Override
    public void addMedicalRequest(MedicalRequest medicalRequest) {
        medicalRequestRepository.save(medicalRequest);
    }
}
