package com.example.model.service;

import com.example.model.entity.Usuario;
import com.example.model.repository.UsuarioRepository;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, String, UsuarioRepository> {
    @Autowired
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder(); }
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getByUsername(String username) { return usuarioRepository.findByUsername(username);}

    public void add(Usuario u) {
        if (getByUsername(u.getUsername()) == null &&
        u.getPassword() != null) {
            System.out.println("El usuario no existe");
            u.setRole("USER");
            u.setPassword(passwordEncoder().encode(u.getPassword()));
            usuarioRepository.save(u);
        } else {
            System.out.println("No se pudo crear el usuario");
        }
    }

    @PostConstruct
    public void init() {
        //usuarioRepository.save(new Usuario("kenneth", passwordEncoder().encode("kenneth"), "ADMIN"));
        //usuarioRepository.save(new Usuario("user", passwordEncoder().encode("user"), "USER"));
    }
}
