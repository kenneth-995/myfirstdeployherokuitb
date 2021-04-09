package com.example.controller;

import com.example.model.entity.Usuario;
import com.example.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/registre")
    public String registre(Model model) {
        model.addAttribute("userForm", new Usuario());
        return "registre";
    }

    @PostMapping("/registre")
    public String submitUser(@ModelAttribute("userForm") Usuario u,
                             Model model) {
        Usuario user = usuarioService.getByUsername(u.getUsername());
        if (user == null) {
            usuarioService.add(u);
            return "redirect:/login";
        } else { //existe
            model.addAttribute("exist", true);
            return "registre";
        }


    }
}
