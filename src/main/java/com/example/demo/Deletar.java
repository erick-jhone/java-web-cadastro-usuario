package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "deletar", value = "/deletar")
public class Deletar extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
           HttpSession sessao=request.getSession(false);
           if(sessao!=null)
           {
               Usuario u=(Usuario) sessao.getAttribute("usuario");
               out.print("<h2>Seja bem vindo "+u.getNome()+"</h2>");
           }
        String tId=request.getParameter("id");
        if(tId!=null && !tId.isBlank())//diferente de nulo e não vazio
        {
            Usuario u=new Usuario(Integer.parseInt(tId));
            Set<Usuario> usuarios=(Set<Usuario>)getServletContext().getAttribute("usuarios");
            if(usuarios.remove(u))
                out.print("<p>Removido com sucesso");
            else
                out.print("<p>Falha ao tentar remover");
            out.print("<p><a href='relatorio'>Relatório</a>");
        }
        else
            out.print("<p>Você precisa informar o ID");



        out.println("</body></html>");
    }

}