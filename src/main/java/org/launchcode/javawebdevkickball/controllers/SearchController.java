package org.launchcode.javawebdevkickball.controllers;

import org.launchcode.javawebdevkickball.models.TeamPosition;
import org.launchcode.javawebdevkickball.models.TeamData;
import org.launchcode.javawebdevkickball.models.data.TeamPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static org.launchcode.javawebdevkickball.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private TeamPositionRepository teamPositionRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<TeamPosition> jobs;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            jobs = teamPositionRepository.findAll();
        } else {
            jobs = TeamData.findByColumnAndValue(searchType, searchTerm, teamPositionRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("jobs", jobs);
        return "search";
    }
}