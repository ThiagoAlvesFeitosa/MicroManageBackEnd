package com.example.login_api.service.impl;

import com.example.login_api.dto.LoginDTO;
import com.example.login_api.dto.UsuarioDTO;

import com.example.login_api.entity.Usuario;
import com.example.login_api.repo.UsuarioRepo;
import com.example.login_api.response.LoginResponse;
import com.example.login_api.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class UsuarioIMPL implements UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario(

                usuarioDTO.getIdUsuario(),
                usuarioDTO.getNomeUsuario(),
                usuarioDTO.getEmail(),

                this.passwordEncoder.encode(usuarioDTO.getSenha())
        );

        usuarioRepo.save(usuario);

        return usuario.getUsuarioname();
    }

    UsuarioDTO usuarioDTO;
    @Override
    public LoginResponse  loginUsuario(LoginDTO loginDTO) {
        String msg = "";
        Usuario usuario1 = usuarioRepo.findByEmail(loginDTO.getEmail());
        if (usuario1 != null) {
            String password = loginDTO.getSenha();
            String encodedPassword = usuario1.getSenha();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Usuario> usuario = usuarioRepo.findOneByEmailAndSenha(loginDTO.getEmail(), encodedPassword);
                if (usuario.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }


}