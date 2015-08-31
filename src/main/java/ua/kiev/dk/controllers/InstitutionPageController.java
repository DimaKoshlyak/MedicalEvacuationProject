package ua.kiev.dk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.entities.Institution;
import ua.kiev.dk.services.InstitutionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/MedAutomation")
@ComponentScan("ua.kiev.dk")
public class InstitutionPageController {

    @Autowired
    private InstitutionManager institutionManager;


    @RequestMapping(value = "/open_add_institution_page", method = RequestMethod.POST)
    public String openAddInstitutionPage(Model model) {
        return "add_institution";
    }

    @RequestMapping(value = "/delete_institution")
    public ModelAndView deleteInstitution(@RequestParam(value = "id") long id) {
        institutionManager.deleteInstitution(id);
        return new ModelAndView("institutions_page", "institutions", institutionManager.listOfInstitutions());
    }

    @RequestMapping(value = "/add_institution", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8"})
    public ModelAndView addAdv(@RequestParam(value = "institutionName") String institutionName,
                               @RequestParam(value = "institutionType") String institutionType,
                               @RequestParam(value = "institutionCity") String institutionCity,
                               @RequestParam(value = "institutionCoordinateX") String institutionCoordinateX,
                               @RequestParam(value = "institutionCoordinateY") String institutionCoordinateY,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        Institution institution = new Institution(institutionName, institutionType, institutionCity, institutionCoordinateX, institutionCoordinateY);
        institutionManager.addInstitution(institution);
        return new ModelAndView("institutions_page", "institutions", institutionManager.listOfInstitutions());
    }
}
