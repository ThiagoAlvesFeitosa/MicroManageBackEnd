package com.example.login_api.service;

import com.example.login_api.dto.LoginDTO;
import com.example.login_api.dto.UsuarioDTO;
import com.example.login_api.response.LoginResponse;

public interface UsuarioService {


    String addUsuario(UsuarioDTO usuarioDTO);


    LoginResponse loginUsuario(LoginDTO loginDTO);
}
