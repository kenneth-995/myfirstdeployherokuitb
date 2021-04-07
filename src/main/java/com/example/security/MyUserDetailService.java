package com.example.security;

import com.example.model.entity.Usuario;
import com.example.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioService.getByUsername(username);
        User.UserBuilder builder ;
        if (u != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(u.getPassword());
            //builder.authorities(new SimpleGrantedAuthority("ADMIN"));
            builder.roles(u.getRole());
        } else {
            throw new UsernameNotFoundException("Usuari no trobat");
        }
        return builder.build();
    }
}
