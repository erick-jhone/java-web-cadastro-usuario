package com.example.demo;

import java.util.List;
import java.util.Objects;

public class Usuario {
    int id;
    String nome,login,senha;
    private List<Telefone> telefones;


    public Usuario(){}
    public Usuario(int id) {
        this.id = id;
    }
    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
    }

    public void removeTelefone(String numero) {
        for (Telefone tel : telefones) {
            if(numero.equals(tel.getTelefone())) {
               telefones.remove(tel);
            }
        }
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
                "</td><td>" +  "telefones" + "</td>"+
                "</td><td>" + login+
                "</td><td>" + senha + "</td>"+
                "<td><a href='deletar?id="+id+"'>Deletar</a></td>"+
                "<td><a href='editar?id="+id+"'>Editar</a></td>"+
                "<td><a href='javascript:void(0);' onclick='deletarTelefone()'>Deletar telefone</a></td>"+
                "<td><a href='javascript:void(0);' onclick='adicionarTelefone()'>Adicionar telefone</a></td>"+
                "</tr>";
    }
}
