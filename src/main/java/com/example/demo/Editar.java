package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "editar", value = "/editar")
public class Editar extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession sessao=request.getSession(false);
        if(sessao!=null)
        {
            Usuario u=(Usuario) sessao.getAttribute("usuario");
            out.print("<h2>Dados cadastrais de: "+u.getNome()+"</h2>");
            out.println("<h3>Editar cadastro</h3>\n" +
                    "  <form action=\"processaralteracoes\" method=\"post\">\n" +
                    "    <label>Nome\n" +
                    "        <input type=\"text\" name=\"nome\">\n" +
                    "    </label>\n" +
                    "    <label>Telefone\n" +
                    "      <input type=\"text\" name=\"telefone\">\n" +
                    "    </label>\n" +
                    "    <label>Login\n" +
                    "      <input type=\"text\" name=\"login\">\n" +
                    "    </label>\n" +
                    "    <label>Senha\n" +
                    "      <input type=\"password\" name=\"senha\">\n" +
                    "    </label>\n" +
                    "    <input type=\"submit\" value=\"Alterar\">\n" +
                    "  </form>");


        }




    }
}
