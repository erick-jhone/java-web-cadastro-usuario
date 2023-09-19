package com.example.demo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.*;

@WebListener
public class Ouvinte implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent evento) {
        Set<Usuario> usuarios = new HashSet();
        Usuario u1=new Usuario(1,"José","jose","123");
        Usuario u2=new Usuario(2,"Maria","maria","abc");
        usuarios.add(u1);
        usuarios.add(u2);
        int serial=2;
        ServletContext aplicacao=evento.getServletContext();
        aplicacao.setAttribute("usuarios",usuarios);
        aplicacao.setAttribute("serial",serial);
    }
}
