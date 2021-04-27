package com.example.controller;

import com.example.model.dto.exchange.CreateUpdateExcangeDTOWeb;
import com.example.model.dto.includedguide.CreateUpdateIncludedGuideDTO;
import com.example.model.entity.Drug;
import com.example.model.entity.Subfamily;
import com.example.model.service.DrugService;
import com.example.model.service.IncludedGuideService;
import com.example.model.service.SubfamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/includedguide")
@RequiredArgsConstructor
public class IncludedGuideWebController {

    private final IncludedGuideService includedGuideService;
    private final DrugService drugService;
    private final SubfamilyService subfamilyService;

    @GetMapping("/")
    private String list(Model model) {
        model.addAttribute("includes", includedGuideService.findAll());
        model.addAttribute("namedrug", "");
        model.addAttribute("namesubfamily", "");
        return "listincludedguide";
    }

    @GetMapping("/new")
    private String add(Model model) {
        model.addAttribute("included", new CreateUpdateIncludedGuideDTO());
        List<Subfamily> subfamilies = subfamilyService.findAll();
        model.addAttribute("subfamilies", subfamilies);
        List<Drug> drugs = drugService.findAll();
        model.addAttribute("drugs", drugs);
        return "createediteincludedguide";
    }

    @PostMapping("/new/submit")
    public String addSubmit(@ModelAttribute("included") CreateUpdateIncludedGuideDTO dto)  {
        System.out.println(dto.getId());
        System.out.println(dto.getSubfamilyId());
        System.out.println(dto.getDrugid());
        includedGuideService.createWeb(dto);
        return "redirect:/web/includedguide/";
    }

    @PostMapping("/findbydrugname")
    public String findByCurrentName(Model model,
                                    @ModelAttribute("namedrug") String name){
        System.out.println("Recived namedrug = " + name);

        model.addAttribute("includes", includedGuideService.findByDrugNameWeb(name));

        return "listincludedguide";
    }

    @PostMapping("/findbysubfamilyname")
    public String findBySubfamilyName(Model model,
                                    @ModelAttribute("namesubfamily") String name){
        System.out.println("Recived subfamily = " + name);

        model.addAttribute("includes", includedGuideService.findBySubfamilyNameWeb(name));

        return "listincludedguide";
    }

}
