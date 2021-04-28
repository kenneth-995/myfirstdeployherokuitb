package com.example.controller;

import com.example.model.entity.Usuario;
import com.example.model.service.UsuarioService;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UsuarioService usuarioService;

//    @CrossOrigin(value = "http://localhost:4200")
//    @GetMapping("/login")
//    public Usuario login(HttpServletRequest request) {
////        System.out.println("request.getHeader(Authorization): "+request.getHeader("Authorization"));
////        String[] a = request.getHeader("Authorization").split(" ");
////
////        byte[] decodedBytes = Base64.getDecoder().decode(a[1]);
////        String decodedString = new String(decodedBytes);
////        //comprobar que usuario y contraseña coinciden
////        System.out.println("decodedString: " + decodedString);
//
//        return usuarioService.getByUsername("kenneth");
//    }


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
