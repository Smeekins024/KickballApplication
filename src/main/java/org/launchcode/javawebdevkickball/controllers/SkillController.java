package org.launchcode.javawebdevkickball.controllers;

import org.launchcode.javawebdevkickball.models.Position;
import org.launchcode.javawebdevkickball.models.data.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "skills")
public class SkillController {

    public SkillController() {
    }

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Position());
        return "skills/add";
    }

    @RequestMapping("")
    public String index(Model model) {
        Iterable<Position> skills;
        skills = positionRepository.findAll();
        model.addAttribute("title", "All Skills");
        model.addAttribute("skills", skills);
        return "skills/index";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Position newPosition,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        }
        positionRepository.save(newPosition);
        return "redirect:";
    }

    @RequestMapping(value = "view/{skillId}")
    public String displayViewEmployer(Model model, @PathVariable int skillId) {
        Optional optSkill = positionRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Position position = (Position) optSkill.get();
            model.addAttribute("position", position);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
