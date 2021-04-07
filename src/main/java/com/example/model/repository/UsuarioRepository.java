package com.example.model.repository;

import com.example.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuarioRepository extends JpaRepository<Usuario, String> ,
        JpaSpecificationExecutor<Usuario> {

    Usuario findByUsername(String username);

}
