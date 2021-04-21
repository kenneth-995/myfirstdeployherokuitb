package com.example.controller;

import com.example.error.Family.FamilyNotFoundException;
import com.example.model.entity.Family;
import com.example.model.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/family")
public class FamilyWebController {

    private final FamilyService familyService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("familyList", familyService.findAll());
        model.addAttribute("name", "");
        model.addAttribute("error", false);
        model.addAttribute("errormessage", "");
        return "listfamily";
    }

    @GetMapping("/list/orderbyname")
    public String listOrderByname(Model model) {
        model.addAttribute("familyList", familyService.findAllOrderByName());
        return "listfamily";
    }

    @PostMapping("/list/findbyname")
    public String findByname(Model model,
                             @ModelAttribute("name") String name) {
        System.out.println("[family web controller] param name: "+ name);
        model.addAttribute("familyList", familyService.findByName(name));
        return "listfamily";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("family", new Family());
        return "createeditfamily";
    }

    @PostMapping ("/new/submit")
    public String addSubmit(@ModelAttribute("family") Family f) {
        familyService.save(f);
        return "redirect:/web/family/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id")Long id) {
        Family family = familyService.findById(id).orElse(null);

        model.addAttribute("family", family);
        return "createeditfamily";
    }

    @PostMapping ("/edit/submit")
    public String editSubmit(@ModelAttribute("family") Family f) {
        familyService.save(f);
        return "redirect:/web/family/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable(value = "id")Long id){
        Family family = familyService.findById(id).orElseThrow(()-> new FamilyNotFoundException(id));
        try {
            familyService.delete(family);
        } catch (Exception ex) {
            model.addAttribute("error", true);
            model.addAttribute("errormessage", ex.getCause());
            System.out.println("[family web controller]: " + ex.getMessage());
        }
        model.addAttribute("familyList", familyService.findAll());


        //return "redirect:/web/family/list";
        return "listfamily";
    }


}
