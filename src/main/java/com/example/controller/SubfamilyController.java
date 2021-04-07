package com.example.controller;

import com.example.model.dto.CreateUptateDTOSubfamily;
import com.example.model.dto.converter.SubfamilyDTOConverter;
import com.example.model.entity.Family;
import com.example.model.entity.Subfamily;
import com.example.model.service.FamilyService;
import com.example.model.service.SubfamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subfamily")
public class SubfamilyController {
    @Autowired
    private SubfamilyService subfamilyService;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private SubfamilyDTOConverter subfamilyDTOConverter;

    @GetMapping("/list")
    public String toList(Model model) {
        model.addAttribute("subfamilyList", subfamilyService.findAll());
        return "listsubfamily"; //listfamily.html recojera los datos del Model model
    }

    @GetMapping("/list/orderbyname")
    public String listORderByname(Model model) {
        model.addAttribute("subfamilyList", subfamilyService.findAllOrderByName());
        return "listsubfamily"; //listfamily.html recojera los datos del Model model
    }

    //TODO
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id")Long id) {
        Subfamily subfamily = subfamilyService.findById(id).orElse(null);
        System.out.println("subfamily= " +subfamily.toString());
        //transform entity to dto
        CreateUptateDTOSubfamily subfamilyDto = subfamilyDTOConverter.convertEntityToDto(subfamily);
        System.out.println("subfamilydto.getfamilyId (edit)" + subfamilyDto.getId());

        model.addAttribute("subfamilydto", subfamilyDto);
        List<Family> familyList = familyService.findAll();
        model.addAttribute("familyList", familyList);

        return "createeditsubfamily";
    }

    @PostMapping ("/edit/submit")
    public String updateSubmit(@ModelAttribute("subfamilyDto") CreateUptateDTOSubfamily subfamilydto) {

        Subfamily subfamily = subfamilyDTOConverter.convertDtoToEntity(subfamilydto);
        subfamilyService.save(subfamily);
        return "redirect:/subfamily/list";
    }

}
