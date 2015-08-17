package ua.kiev.dk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.entities.Institution;
import ua.kiev.dk.entities.MedicalRequest;
import ua.kiev.dk.entities.Unit;
import ua.kiev.dk.services.CrewManager;
import ua.kiev.dk.services.InstitutionManager;
import ua.kiev.dk.services.MedicalRequestManager;
import ua.kiev.dk.services.UnitManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/MedAutomation")
@ComponentScan("ua.kiev.dk")
public class MainController {

    @Autowired
    private MedicalRequestManager medicalRequestManager;
    @Autowired
    private CrewManager crewManager;
    @Autowired
    private InstitutionManager institutionManager;
    @Autowired
    private UnitManager unitManager;

    @RequestMapping("/")
    public ModelAndView listMedRequests() {
        return new ModelAndView("index", "medical_requests", medicalRequestManager.listActiveMedicalRequests());
    }

    @RequestMapping("/show_archive")
    public ModelAndView showArchiveRequests() {
        return new ModelAndView("archive", "medical_requests", medicalRequestManager.listArchiveRequests());
    }

    @RequestMapping("/show_crews")
    public ModelAndView showCrews() {
        return new ModelAndView("crews_page", "crews", crewManager.listCrews());
    }

    @RequestMapping("/show_all_units")
    public ModelAndView showUnits(){return  new ModelAndView("units_page","units",unitManager.listUnits());}

    @RequestMapping(value = "/show_institutions")
    public ModelAndView showInstitutions() {
        return new ModelAndView("institutions_page", "institutions", institutionManager.listOfInstitutions());
    }

    @RequestMapping("/departure_point_info")
    public ModelAndView showCoordinates(@RequestParam(value = "id") long id) {
        return new ModelAndView("coordinates", "medical_requests", medicalRequestManager.showCoordinates(id));
    }

    @RequestMapping(value = "/open_add_request_page", method = RequestMethod.POST)
    public ModelAndView addMedicalRequest() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("crews", crewManager.listCrews());
        model.put("institutions", institutionManager.listOfInstitutions());
        return new ModelAndView("add_request", model);
    }

    @RequestMapping("/close_request")
    public ModelAndView moveToArchive(@RequestParam(value = "id") long id) {
        medicalRequestManager.moveToArchive(id);
        return new ModelAndView("index", "medical_requests", medicalRequestManager.listActiveMedicalRequests());
    }

    @RequestMapping(value = "/add_request", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8"})
    public ModelAndView addAdv(@RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName,
                               @RequestParam(value = "sex") String sex,
                               @RequestParam(value = "brigade") String brigade,
                               @RequestParam(value = "battalion") String battalion,
                               @RequestParam(value = "bloodType") String bloodType,
                               @RequestParam(value = "weight") int weight,
                               @RequestParam(value = "tokenNumber") int tokenNumber,
                               @RequestParam(value = "status") String status,
                               @RequestParam(value = "injury") String injury,
                               @RequestParam(value = "painReaction") String painReaction,
                               @RequestParam(value = "breath") String breath,
                               @RequestParam(value = "extremityAvulsion") String extremityAvulsion,
                               @RequestParam(value = "bloodPressure") String bloodPressure,
                               @RequestParam(value = "careType") String careType,
                               @RequestParam(value = "departurePointName") String departurePointName,
                               @RequestParam(value = "departurePointCoordinateX") String departurePointCoordinateX,
                               @RequestParam(value = "departurePointCoordinateY") String departurePointCoordinateY,
                               @RequestParam(value = "destinationInstitution") String destinationInstitution,
                               @RequestParam(value = "evacuationCrew") String evacuationCrew,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        Unit unit = new Unit(firstName, lastName, sex, battalion, bloodType, weight, tokenNumber, brigade);
        unitManager.addUnit(unit);
        Institution destinationInst = institutionManager.returnInstitutionFromName(destinationInstitution);
        Crew crew = crewManager.returnCrewFromName(evacuationCrew);
        MedicalRequest medicalRequest = new MedicalRequest(unit, status, injury, breath, bloodPressure, careType, departurePointName, departurePointCoordinateX, departurePointCoordinateY, destinationInst, crew);
        medicalRequest.setPainReaction(painReaction.equals("Сохранена") ? true : false);
        medicalRequest.setExtremityAvulsion(extremityAvulsion.equals("Присутствует") ? true : false);
        medicalRequestManager.addMedicalRequest(medicalRequest);
        return new ModelAndView("index", "medical_requests", medicalRequestManager.listActiveMedicalRequests());
    }
}
