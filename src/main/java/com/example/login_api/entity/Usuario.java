package com.example.login_api.entity;


import jakarta.persistence.*;



@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @Column(name="id_usuario", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;
    @Column(name="nm_usuario", length = 255)
    private String nomeUsuario;
    @Column(name="email_usuario", length = 255)
    private String email;
    @Column(name="senha_usuario", length = 255)
    private String senha;

    public Usuario() {
    }

    public Usuario(int usuarioId, String usuarioNome, String email, String senha) {
        this.idUsuario = usuarioId;
        this.nomeUsuario = usuarioNome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nomeUsuario, String email, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }


    public int getUsuarioid() {
        return idUsuario;
    }

    public void setUsuarioid(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarioname() {
        return nomeUsuario;
    }

    public void setUsuarioname(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}