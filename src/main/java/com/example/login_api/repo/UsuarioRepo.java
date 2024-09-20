package com.example.login_api.repo;



import com.example.login_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer>
{
    Optional<Usuario> findOneByEmailAndSenha(String email, String senha);

    Usuario findByEmail(String email);
}