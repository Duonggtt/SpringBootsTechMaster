package com.example.crudemployee.controller;

import com.example.crudemployee.model.Employer;
import com.example.crudemployee.repository.EmployerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployerController {

    private EmployerRepository employerRepository;

    private int id = 1;

    @GetMapping("/addEmployer")
    public String addEmployerPlatform(Model model) {
        model.addAttribute("employer", new Employer());
        return "add-employer";
    }

    @PostMapping("/addEmployer")
    public String addEmployee(Employer employer) {
        employerRepository.employers.put(id,employer);
        employer.setId(id);
        id++;
        return "redirect:/employer-list";
    }

    @GetMapping("/employer-list")
    public String employerList(Model model) {
        model.addAttribute("employers", employerRepository.employers.values());
        return "employer-list";
    }
}
