package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "sair", value = "/sair")
public class Sair extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");

           PrintWriter out = response.getWriter();
           out.println("<html><body>");
            HttpSession sessao=request.getSession(false);
            if(sessao!=null)
            {
                Usuario u=(Usuario) sessao.getAttribute("usuario");
                sessao.invalidate();
                out.print("<p>Tchau "+u.getNome());
            }
            else{
                out.print("<p>Você não estava logado");
            }


        // Hello


        out.println("</body></html>");
    }

}