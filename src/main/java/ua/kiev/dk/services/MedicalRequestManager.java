package ua.kiev.dk.services;

import ua.kiev.dk.entities.MedicalRequest;

import java.util.List;

/**
 * Created by d.koshlyak on 10.08.2015.
 */
public interface MedicalRequestManager {

    List<MedicalRequest> listActiveMedicalRequests();
}
