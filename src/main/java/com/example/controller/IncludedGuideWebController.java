package com.example.controller;

import com.example.model.service.DrugService;
import com.example.model.service.IncludedGuideService;
import com.example.model.service.SubfamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "listincludedguide";
    }

}
