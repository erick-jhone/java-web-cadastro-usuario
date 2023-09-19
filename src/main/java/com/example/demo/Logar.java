package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "logar", value = "/logar")
public class Logar extends HttpServlet {
       public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
           PrintWriter out = response.getWriter();
           out.println("<html><body>");

        if(login!=null && login.length()>0 && senha!=null && senha.length()>0){
            Set<Usuario> usuarios=(Set<Usuario>)getServletContext().getAttribute("usuarios");
            HttpSession sessao=null;
            for(Usuario u:usuarios)
            {
                if(u.getLogin().equals(login) && u.getSenha().equals(senha))
                {
                    sessao= request.getSession();
                    sessao.setAttribute("usuario",u);
                    out.print("<p>Logado com sucesso: "+sessao.getId());
                    break;
                }
            }
            if(sessao==null)
                out.print("<p>Login ou senha incorretos");
        }
        else {
            out.print("<p>Você precisa informar o login e a senha.</p>");
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