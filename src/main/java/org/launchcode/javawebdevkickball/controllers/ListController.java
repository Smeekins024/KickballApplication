package org.launchcode.javawebdevkickball.controllers;

import org.launchcode.javawebdevkickball.models.Position;
import org.launchcode.javawebdevkickball.models.Team;
import org.launchcode.javawebdevkickball.models.TeamPosition;
import org.launchcode.javawebdevkickball.models.data.TeamRepository;
import org.launchcode.javawebdevkickball.models.data.TeamPositionRepository;
import org.launchcode.javawebdevkickball.models.data.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.launchcode.javawebdevkickball.models.TeamData;
import java.util.HashMap;


@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private TeamPositionRepository teamPositionRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PositionRepository positionRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();
    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("employer", "Team");
        columnChoices.put("skill", "Position");
    }

    @RequestMapping("")
    public String list(Model model) {
        Iterable<Team> employers;
        employers = teamRepository.findAll();
        model.addAttribute("employers", employers);
        Iterable<Position> skills;
        skills = positionRepository.findAll();
        model.addAttribute("skills", skills);
        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<TeamPosition> jobs;
        if (column.toLowerCase().equals("all")){
            jobs = teamPositionRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = TeamData.findByColumnAndValue(column, value, teamPositionRepository.findAll());
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("jobs", jobs);
        return "list-jobs";
    }
}
