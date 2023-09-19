package com.example.demo;

import java.util.Objects;

public class Usuario {
    int id;
    String nome,telefone,login,senha;

    public Usuario(){}
    public Usuario(int id) {
        this.id = id;
    }
    public Usuario(int id, String nome, String telefone, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "<tr><td>" + id +
                "</td><td>" + nome +
                "</td><td>" + telefone +
                "</td><td>" + login+
                "</td><td>" + senha + "</td>"+
                "<td><a href='deletar?id="+id+"'>Deletar</a></td>"+
                "<td><a href='editar?id="+id+"'>Editar</a></td>"+
                "</tr>";
    }
}
