package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "processaralteracoes", value = "/processaralteracoes")

public class ProcessarAlteracoes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String novoNome = (String) req.getParameter("nome");
        PrintWriter out = resp.getWriter();
        String novoLogin = req.getParameter("login");
        String novaSenha = req.getParameter("senha");
        HttpSession sessao=req.getSession(false);
        if (sessao!=null){
            Usuario u=(Usuario) sessao.getAttribute("usuario");
            if(novoNome!=null && !novoNome.isEmpty()){
            u.setNome(novoNome);
            }

            if(novoLogin!=null && !novoLogin.isEmpty()){
                u.setLogin(novoLogin);
            }

            if(novaSenha!=null && !novaSenha.isEmpty()){
                u.setSenha(novaSenha);
            }

            out.print("<script>function alertar(){alert('Alterações realizadas');" +
                    " window.location.href = 'relatorio'"+
                    "}</script>");
            out.print("<script>alertar();</script>");


        }



    }
}
