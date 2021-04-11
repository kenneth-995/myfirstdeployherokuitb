package com.example.controller;

import com.example.model.dto.converter.ExchangeDTOConverter;
import com.example.model.dto.exchange.CreateUpdateExcangeDTOWeb;
import com.example.model.entity.Drug;
import com.example.model.entity.Exchange;
import com.example.model.entity.Subfamily;
import com.example.model.service.DrugService;
import com.example.model.service.ExchangeService;
import com.example.model.service.SubfamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/exchange")
@RequiredArgsConstructor
public class ExchangeWebController {

    private final ExchangeService exchangeService;
    private final SubfamilyService subfamilyService;
    private final DrugService drugService;

    private final ExchangeDTOConverter exchangeDTOConverter;

    @GetMapping("/")
    public String toList(Model model) {
        model.addAttribute("exchanges", exchangeService.findAll());
        return "listexchange";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("exchangedto", new CreateUpdateExcangeDTOWeb());
        List<Subfamily> subfamilies = subfamilyService.findAll();
        model.addAttribute("subfamilies", subfamilies);
        List<Drug> drugs = drugService.findAll();
        model.addAttribute("drugs", drugs);
        return "createeditexchange";
    }

    @PostMapping("/new/submit")
    public String addSubmit(@ModelAttribute("exchangedto") CreateUpdateExcangeDTOWeb dto)  {
        exchangeService.createWeb(dto);
        return "redirect:/web/exchange/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") Long id) {
        Exchange exchange = exchangeService.findById(id).orElse(null);
        CreateUpdateExcangeDTOWeb dto = exchangeDTOConverter.convertEntityToDtoWeb(exchange);
        model.addAttribute("exchangedto", dto);
        List<Subfamily> subfamilies = subfamilyService.findAll();
        model.addAttribute("subfamilies", subfamilies);
        List<Drug> drugs = drugService.findAll();
        model.addAttribute("drugs", drugs);
        return "createeditexchange";
    }

    @PostMapping ("/edit/submit")
    public String editSubmit(@ModelAttribute("exchangedto") CreateUpdateExcangeDTOWeb dtoWeb) {
        Exchange exchange = exchangeDTOConverter.convertDtoToEntityWeb(dtoWeb);
        exchangeService.save(exchange);
        return "redirect:/web/exchange/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        Exchange exchange = exchangeService.findById(id).orElse(null);
        if (exchange != null)
            exchangeService.delete(exchange);

        return "redirect:/web/exchange/";
    }

}
