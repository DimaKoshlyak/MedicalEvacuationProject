package ua.kiev.dk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.entities.MedicalRequest;
import ua.kiev.dk.services.CrewManager;
import ua.kiev.dk.services.MedicalRequestManager;

import java.util.List;

@RestController
@RequestMapping("/MedAutomation")
public class RestJSONController {

    @Autowired
    private MedicalRequestManager medicalRequestManager;

    @Autowired
    private CrewManager crewManager;

    @RequestMapping(value ="/mrequests_json")
    public List<MedicalRequest> getMedicalRequests() {
        List<MedicalRequest> medicalRequests = getMedicalRequestsList();
        return medicalRequests;
    }

    @RequestMapping(value ="/crews_json")
    public List<Crew> getCrews() {
        List<Crew> crews = getCrewsList();
        return crews;
    }

    private List<MedicalRequest> getMedicalRequestsList(){
        return medicalRequestManager.listActiveMedicalRequests();
    }

    private List<Crew> getCrewsList(){
        return crewManager.listCrews();
    }
}
