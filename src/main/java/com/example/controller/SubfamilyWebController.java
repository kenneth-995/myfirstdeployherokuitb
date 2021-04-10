package com.example.controller;

import com.example.model.dto.converter.SubfamilyDTOConverterWeb;
import com.example.model.dto.subfamily.CreateUpdateDTOSubfamilyWeb;
import com.example.model.dto.subfamily.CreateUptateDTOSubfamily;
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
@RequestMapping("/web/subfamily")
public class SubfamilyWebController {
    @Autowired
    private SubfamilyService subfamilyService;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private SubfamilyDTOConverterWeb subfamilyDTOConverterWeb;

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


    @GetMapping("/list/findbyname") // http://localhost:5000/web/subfamily/list/findbyname/?name=al
    public String findByname(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("subfamilyList", subfamilyService.findByName(name));
        return "listsubfamily";
    }


    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("subfamilydto", new CreateUpdateDTOSubfamilyWeb());
        List<Family> familyList = familyService.findAll();
        model.addAttribute("familyList", familyList); // rellenamos el select del formulario con las familias
        return "createeditsubfamily";
    }

    @PostMapping ("/new/submit")
    public String addSubmit(@ModelAttribute("subfamilydto") CreateUpdateDTOSubfamilyWeb dtoSubfamilyWeb) {
        // buscar la familia
        // crear la subfamilia y guardarla
        System.out.println(dtoSubfamilyWeb.getName());
        System.out.println(dtoSubfamilyWeb.getFamilyid());
        Family family = familyService.findById(dtoSubfamilyWeb.getFamilyid()).orElse(null);
        Subfamily subfamily = new Subfamily();
        subfamily.setFamily(family);
        subfamily.setName(dtoSubfamilyWeb.getName());
        subfamilyService.save(subfamily);
        return "redirect:/web/subfamily/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id")Long id) {
        Subfamily subfamily = subfamilyService.findById(id).orElse(null);

        CreateUpdateDTOSubfamilyWeb subfamilyDto = subfamilyDTOConverterWeb.convertEntityToDto(subfamily);
        model.addAttribute("subfamilydto", subfamilyDto); //rellenamos el formulario con los datos de la subfamilia
        List<Family> familyList = familyService.findAll();
        model.addAttribute("familyList", familyList);

        return "createeditsubfamily";
    }

    @PostMapping ("/edit/submit")
    public String updateSubmit(@ModelAttribute("subfamilyDto") CreateUpdateDTOSubfamilyWeb subfamilydto) {

        Subfamily subfamily = subfamilyDTOConverterWeb.convertDtoToEntity(subfamilydto);
        subfamilyService.save(subfamily);
        return "redirect:/web/subfamily/list";
    }

    @GetMapping("/delete/{id}") // TODO: DeleteMapping?
    public String delete(@PathVariable(value = "id")Long id){
        Subfamily subfamily = subfamilyService.findById(id).orElse(null);
        if (subfamily != null)
            subfamilyService.delete(subfamily);

        return "redirect:/web/subfamily/list";
    }

}
