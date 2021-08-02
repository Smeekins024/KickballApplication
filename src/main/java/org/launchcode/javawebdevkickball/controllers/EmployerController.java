package org.launchcode.javawebdevkickball.controllers;


import org.launchcode.javawebdevkickball.models.Team;
import org.launchcode.javawebdevkickball.models.data.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "employers")
public class EmployerController{

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Team());
        return "employers/add";
    }

    @RequestMapping("")
    public String index(Model model) {
        Iterable<Team> employers;
        employers = teamRepository.findAll();
        model.addAttribute("title", "All Employers");
        model.addAttribute("employers", employers);
        return "employers/list-employers";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Team newTeam,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "employers/add";
        }
        teamRepository.save(newTeam);
        return "redirect:";
    }

    @RequestMapping(value = "view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {
        Optional optEmployer = teamRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Team team = (Team) optEmployer.get();
            model.addAttribute("team", team);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
