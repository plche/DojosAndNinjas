package com.codingdojo.peru.ft2022.dsans.controllers;

import com.codingdojo.peru.ft2022.dsans.models.Dojo;
import com.codingdojo.peru.ft2022.dsans.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DojoController {
    @Autowired
    DojoService dojoService;

    @GetMapping("/dojos/new")
    public String showNewDojosForm(@ModelAttribute("dojo") Dojo dojo) {
        return "newdojo.jsp";
    }

    @PostMapping("/dojos/new")
    public String saveNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) return "newdojo.jsp";
        else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable Long id, Model model) {
        Dojo dojo = dojoService.findDojoById(id);
        model.addAttribute("dojo", dojo);
        return "showdojo.jsp";
    }
}
