package ua.kiev.dk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.services.CrewManager;
import ua.kiev.dk.services.InstitutionManager;
import ua.kiev.dk.services.MedicalRequestManager;
import ua.kiev.dk.services.UnitManager;

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
		return new ModelAndView("index","medical_requests", medicalRequestManager.listActiveMedicalRequests());
	}

//	@RequestMapping(value = "/add_page", method = RequestMethod.POST)
//	public String addPage(Model model) {
//		return "add_page";
//	}
//
	@RequestMapping("/show_archive")
	public ModelAndView showArchiveRequests() { return new ModelAndView("archive","medical_requests", medicalRequestManager.listArchiveRequest()); }
//
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam(value="pattern") String pattern) {
		return new ModelAndView("index", "advs", crewManager.list(pattern));
	}


	@RequestMapping("/departure_point_info")
	public ModelAndView showCoordinates(@RequestParam(value="id") long id) {
		System.out.println("id = " + id);
		return new ModelAndView("coordinates","medical_requests",medicalRequestManager.showCoordinates(id));
	}
//
	@RequestMapping("/close_request")
	public ModelAndView moveToArchive(@RequestParam(value="id") long id) {
		medicalRequestManager.moveToArchive(id);
		return new ModelAndView("index", "medical_requests", medicalRequestManager.listActiveMedicalRequests());
	}
//
//	@RequestMapping(value = "/process_checked", method = RequestMethod.POST)
//	public ModelAndView processChecked(HttpServletRequest request) {
//		String[] str = request.getParameterValues("selectrow[]");
//		String whatToDo = request.getParameter("submit");
//		if (str != null)
//			for (String idstr : str) {
//				if (whatToDo.equals("delete")) {
//					crewManager.delete(Long.valueOf(idstr));
//				} else if (whatToDo.equals("restore")) {
//					crewManager.restoreFromTrash(Long.valueOf(idstr));
//				}
//			}
//		return new ModelAndView("trash", "advs", crewManager.listBin());
//	}
//
//	@RequestMapping("/image/{file_id}")
//	public void getFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("file_id") long fileId) {
//		try {
//			byte[] content = crewManager.getPhoto(fileId);
//			response.setContentType("image/png");
//			response.getOutputStream().write(content);
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}
//
//@RequestMapping(value = "/add", method = RequestMethod.POST)
//public ModelAndView addAdv(@RequestParam(value="name") String name,
//						   @RequestParam(value="shortDesc") String shortDesc,
//						   @RequestParam(value="longDesc", required=false) String longDesc,
//						   @RequestParam(value="phone") String phone,
//						   @RequestParam(value="price") double price,
//						   @RequestParam(value="photo") MultipartFile photo,
//						   HttpServletRequest request,
//						   HttpServletResponse response)
//{
//	try {
//		Advertisement adv = new Advertisement(
//				name, shortDesc, longDesc, phone, price,
//				photo.isEmpty() ? null : new Photo(photo.getOriginalFilename(), photo.getBytes())
//		);
//		crewManager.add(adv);
//		return new ModelAndView("index", "advs", crewManager.list());
//	} catch (IOException ex) {
//		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		return null;
//	}
//}
//
//	@RequestMapping("/load_xml")
//	public ModelAndView importXml(@RequestParam(value = "xmlfile") MultipartFile mfile) {
//		InputStream inputStream = null;
//		Reader reader = null;
//		try {
//			inputStream = mfile.getInputStream();
//			reader = new InputStreamReader(inputStream, "UTF-8");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		JAXBContext jaxbContext = null;
//		Unmarshaller unmarshaller = null;
//		AdvertisementList advList = null;
//		try {
//			jaxbContext = JAXBContext.newInstance(AdvertisementList.class);
//			unmarshaller = jaxbContext.createUnmarshaller();
//			advList = (AdvertisementList) unmarshaller.unmarshal(reader);
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//		for (Advertisement adv : advList.getAdvList()) {
//			adv.setTo_del(false);
//			crewManager.add(adv);
//		}
//		return new ModelAndView("index", "advs", crewManager.list());
//	}
}