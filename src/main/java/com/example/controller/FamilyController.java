package com.example.controller;

import com.example.model.entity.Family;
import com.example.model.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/list")
    public String toList(Model model) {
        model.addAttribute("familyList", familyService.findAll());
        return "listfamily"; //listfamily.html recojera los datos del Model model
    }

    @GetMapping("/list/orderbyname")
    public String listORderByname(Model model) {
        model.addAttribute("familyList", familyService.findAllOrderByName());
        return "listfamily"; //listfamily.html recojera los datos del Model model
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("family", new Family());
        return "createeditfamily";
    }

    @PostMapping ("/new/submit")
    public String createSubmit(@ModelAttribute("family") Family f) {
        familyService.save(f);
        return "redirect:/family/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id")Long id) {
        Family family = familyService.findById(id).orElse(null);

        model.addAttribute("family", family);
        return "createeditfamily";
    }

    @PostMapping ("/edit/submit")
    public String updateSubmit(@ModelAttribute("family") Family f) {
        familyService.save(f);
        return "redirect:/family/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        Family family = familyService.findById(id).orElse(null);
        if (family != null)
            familyService.delete(family);

        return "redirect:/family/list";
    }


}
