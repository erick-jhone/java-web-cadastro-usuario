package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "relatorio", value = "/relatorio")
public class Relatorio extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession sessao=request.getSession(false);
        Usuario usuarioLogado=null;
        if(sessao!=null)
        {
            usuarioLogado=(Usuario) sessao.getAttribute("usuario");
            out.print("<h2>Seja bem vindo "+usuarioLogado.getNome()+"</h2>");
        }
        Set<Usuario> usuarios=(Set<Usuario>)getServletContext().getAttribute("usuarios");
        out.print("<table>\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Nome</th>\n" +
                "        <th>Telefone</th>\n" +
                "        <th>Login</th>\n" +
                "        <th>Senha</th>\n" +
                "        <th>Deletar</th>\n" +
                "        <th>Editar</th>\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n");

        for(Usuario u:usuarios)
        {
            if(usuarioLogado!=null && usuarioLogado.equals(u))
                out.print(u);
            else
                out.print("<tr><td>" + u.getId() +
                        "</td><td>" + u.getNome() +
                        "</td><td>" + u.getTelefone() +
                        "</td><td>" + u.getLogin()+
                        "</td><td> **** </td>"+
                        "<td><a>Deletar</a></td>"+
                        "<td><a>Editar</a></td>"+
                        "</tr>");
        }
        out.print("    </tbody>\n" +
                "  </table>");

        out.println("</body></html>");
    }

}