package org.launchcode.javawebdevkickball.controllers;

import org.launchcode.javawebdevkickball.models.Team;
import org.launchcode.javawebdevkickball.models.TeamPosition;
import org.launchcode.javawebdevkickball.models.Position;
import org.launchcode.javawebdevkickball.models.data.TeamRepository;
import org.launchcode.javawebdevkickball.models.data.TeamPositionRepository;
import org.launchcode.javawebdevkickball.models.data.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    private TeamPositionRepository teamPositionRepository;
    @Autowired
    private PositionRepository positionRepository;
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        Iterable<TeamPosition> jobs;
        jobs = teamPositionRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add TeamPosition");
        model.addAttribute(new TeamPosition());
        model.addAttribute(new Team());
        Iterable<Team> employers;
        employers = teamRepository.findAll();
        model.addAttribute("employers", employers);
        model.addAttribute(new Position());
        Iterable<Position> skills;
        skills = positionRepository.findAll();
        model.addAttribute("skills", skills);
        return "add";
    }

    @PostMapping("add")
    public String processAddTeamPosition(@ModelAttribute @Valid TeamPosition newTeamPosition,
                                         Errors errors,
                                         Model model,
                                         @RequestParam int TeamId,
                                         @RequestParam List<Integer> skills ) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add TeamPosition");
            return "add";
        } else {
            Optional optTeam = teamRepository.findById(TeamId);
            if (optTeam.isPresent()) {
                Team team = (Team) optTeam.get();
                newTeamPosition.setTeam(team);
                List<Position> positionObjs = (List<Position>) positionRepository.findAllById(skills);
                newTeamPosition.setTeamPositions(positionObjs);
                teamPositionRepository.save(newTeamPosition);
            }
        }
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<TeamPosition> optjob = teamPositionRepository.findById(jobId);
        if (optjob.isPresent()) {
            TeamPosition teamPosition = (TeamPosition) optjob.get();
            model.addAttribute("teamPosition", teamPosition);
        }
        return "view";
    }
}
