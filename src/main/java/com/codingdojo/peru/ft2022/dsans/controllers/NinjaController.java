package com.codingdojo.peru.ft2022.dsans.controllers;

import com.codingdojo.peru.ft2022.dsans.models.Dojo;
import com.codingdojo.peru.ft2022.dsans.models.Ninja;
import com.codingdojo.peru.ft2022.dsans.services.DojoService;
import com.codingdojo.peru.ft2022.dsans.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {
    @Autowired
    NinjaService ninjaService;

    @Autowired
    DojoService dojoService;

    @GetMapping("/ninjas/new")
    public String showNewNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newninja.jsp";
    }

    @PostMapping("/ninjas/new")
    public String saveNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) return "newninja.jsp";
        else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojo().getId();
        }
    }
}
