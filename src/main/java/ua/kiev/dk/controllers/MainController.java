package ua.kiev.dk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.entities.Crew;
import ua.kiev.dk.services.CrewManager;
import ua.kiev.dk.services.InstitutionManager;
import ua.kiev.dk.services.MedicalRequestManager;
import ua.kiev.dk.services.UnitManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
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
	private UnitManager unitManager;
	@Autowired
	private InstitutionManager institutionManager;

	@RequestMapping("/")
	public ModelAndView listMedRequests() {
		return new ModelAndView("index", "medical_requests", medicalRequestManager.listActiveMedicalRequests());
	}

	@RequestMapping("/show_archive")
	public ModelAndView showArchiveRequests() {
		return new ModelAndView("archive", "medical_requests", medicalRequestManager.listArchiveRequest());
	}

	@RequestMapping("/show_crews")
	public ModelAndView showCrews() {
		return new ModelAndView("crews", "crews", crewManager.listCrew());
	}

	@RequestMapping("/show_institutions")
	public ModelAndView showInstitutions() {
		return new ModelAndView("institutions", "institutions", institutionManager.listOfInstitutions());
	}

	@RequestMapping("/departure_point_info")
	public ModelAndView showCoordinates(@RequestParam(value = "id") long id) {
		return new ModelAndView("coordinates", "medical_requests", medicalRequestManager.showCoordinates(id));
	}

	@RequestMapping(value = "/open_add_request_page", method = RequestMethod.POST)
	public ModelAndView addMedicalRequest() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crews", crewManager.listCrew());
		model.put("institutions", institutionManager.listOfInstitutions());
		return new ModelAndView("add_request", model);
	}

	@RequestMapping(value = "/open_add_crew_page",method = RequestMethod.POST)
	public String openAddCrewPage(Model model){
		return "add_crew";
	}

	@RequestMapping("/close_request")
	public ModelAndView moveToArchive(@RequestParam(value = "id") long id) {
		medicalRequestManager.moveToArchive(id);
		return new ModelAndView("index", "medical_requests", medicalRequestManager.listActiveMedicalRequests());
	}

	@RequestMapping(value = "/delete_crew")
	public ModelAndView deleteCrew(@RequestParam(value = "id") long id){
		crewManager.deleteCrew(id);
		return new ModelAndView("crews","crews",crewManager.listCrew());
	}

	@RequestMapping(value = "/add_crew", method = RequestMethod.POST, produces={"text/html;charset=UTF-8"})
	public ModelAndView addAdv(@RequestParam(value = "crewName") String crewName,
							   @RequestParam(value = "member1Name") String member1Name,
							   @RequestParam(value = "member2Name") String member2Name,
							   @RequestParam(value = "car") String car,
							   @RequestParam(value = "reanimation") String reanimation,
							   HttpServletRequest request,
							   HttpServletResponse response) throws UnsupportedEncodingException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		Crew crew = new Crew(
                crewName, member1Name, member2Name, car);
		System.out.println(reanimation);
		System.out.println(member1Name);
		crew.setReanimation((reanimation=="Присутствует") ? true : false);
		crewManager.addCrew(crew);
		return new ModelAndView("crews", "crews", crewManager.listCrew());
	}
}
