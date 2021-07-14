package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    public EmployerRepository employerRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        Iterable<Job> jobs;
        jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute(new Employer());
        Iterable<Employer> employers;
        employers = employerRepository.findAll();
        model.addAttribute("employers", employers);
        model.addAttribute(new Skill());
        Iterable<Skill> skills;
        skills = skillRepository.findAll();
        model.addAttribute("skills", skills);
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors,
                                    Model model,
                                    @RequestParam int employerId,
                                    @RequestParam List<Integer> skills ) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        } else {
            Optional optEmployer = employerRepository.findById(employerId);
            if (optEmployer.isPresent()) {
                Employer employer = (Employer) optEmployer.get();
                newJob.setEmployer(employer);
                List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
                newJob.setSkills(skillObjs);
                jobRepository.save(newJob);
            }
        }
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> optjob = jobRepository.findById(jobId);
        if (optjob.isPresent()) {
            Job job = (Job) optjob.get();
            model.addAttribute("job", job);
        }
        return "view";
    }
}
