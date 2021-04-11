package com.example.controller;

import com.example.model.entity.Drug;
import com.example.model.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/drug")
public class DrugWebController {

    private final DrugService drugService;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("drugs", drugService.findAll());
        return "listdrug";
    }

    @GetMapping("/orderbyname")
    public String listOrderByname(Model model) {
        model.addAttribute("drugs", drugService.findAllOrderByName());
        return "listdrug";
    }

    @GetMapping("/findbyname") // http://localhost:5000/web/drug/findbyname?name=Lacer
    public String findByName(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("drugs", drugService.findByName(name));
        return "listdrug";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("drug", new Drug());
        return "createeditdrug";
    }
    @PostMapping("/new/submit")
    public String addSubmit(@ModelAttribute("drug") Drug d) {
        drugService.save(d);
        return "redirect:/web/drug/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id")Long id) {
        Drug drug = drugService.findById(id).orElse(null);

        model.addAttribute("drug", drug);
        return "createeditdrug";
    }
    @PostMapping ("/edit/submit")
    public String editSubmit(@ModelAttribute("drug") Drug d) {
        drugService.save(d);
        return "redirect:/web/drug/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        Drug drug = drugService.findById(id).orElse(null);
        if (drug != null)
            drugService.delete(drug);

        return "redirect:/web/drug/";
    }

}
