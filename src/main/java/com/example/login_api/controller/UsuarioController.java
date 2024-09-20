package com.example.login_api.controller;

import com.example.login_api.dto.UsuarioDTO;
import  com.example.login_api.dto.LoginDTO;

import com.example.login_api.response.LoginResponse;
import com.example.login_api.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping(path = "/save")
    public String saveUsuario(@RequestBody UsuarioDTO usuarioDTO)
    {
        String id = usuarioService.addUsuario(usuarioDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = usuarioService.loginUsuario(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}