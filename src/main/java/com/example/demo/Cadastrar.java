package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "cadastrar", value = "/cadastrar")
public class Cadastrar extends HttpServlet {
       public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String nome=request.getParameter("nome");
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
           PrintWriter out = response.getWriter();
           out.println("<html><body>");
           HttpSession sessao=request.getSession(false);
           if(sessao!=null)
           {
               Usuario u=(Usuario) sessao.getAttribute("usuario");
               out.print("<h2>Seja bem vindo "+u.getNome()+"</h2>");
           }
        if(nome!=null && nome.length()>0 &&
            login!=null && login.length()>0 && senha!=null && senha.length()>0){

                Usuario u=new Usuario(proximoSerial(),nome,login,senha);

                Set<Usuario> usuarios=(Set<Usuario>)getServletContext().getAttribute("usuarios");
                if(usuarios.add(u))
                {
                    out.print("<p>Cadastrado com sucesso</p>");
                    out.print("<a href='relatorio'>Relatório</a>");
                }
                else
                    out.print("<p>Usuário já está cadastrado</p>");
            System.out.println(usuarios);
        }
        else {
            out.print("<p>Você precisa informar todos os dados.</p>");
        }

        // Hello


        out.println("</body></html>");
    }

    private int proximoSerial(){
        int serial= (Integer) getServletContext().getAttribute("serial");
        serial++;
        getServletContext().setAttribute("serial",serial);
        return  serial;
    }
}