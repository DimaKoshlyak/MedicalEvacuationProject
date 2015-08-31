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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/MedAutomation")
@ComponentScan("ua.kiev.dk")
public class CrewPageController {

    @Autowired
    private CrewManager crewManager;

    @RequestMapping(value = "/open_add_crew_page", method = RequestMethod.POST)
    public String openAddCrewPage(Model model) {
        return "add_crew";
    }

    @RequestMapping(value = "/add_crew", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8"})
    public ModelAndView addAdv(@RequestParam(value = "crewName") String crewName,
                               @RequestParam(value = "member1Name") String member1Name,
                               @RequestParam(value = "member2Name") String member2Name,
                               @RequestParam(value = "car") String car,
                               @RequestParam(value = "reanimation") String reanimation,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        Crew crew = new Crew(
                crewName, member1Name, member2Name, car, reanimation);
        crewManager.addCrew(crew);
        return new ModelAndView("crews_page", "crews", crewManager.listCrews());
    }

    @RequestMapping(value = "/delete_crew")
    public ModelAndView deleteCrew(@RequestParam(value = "id") long id) {
        crewManager.deleteCrew(id);
        return new ModelAndView("crews_page", "crews", crewManager.listCrews());
    }
}
