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
           out.println("<style>");
           out.println("table {");
           out.println("    border-collapse: collapse;");
           out.println("    width: 100%;");
           out.println("    border: 1px solid #ccc;");
           out.println("}");

           out.println("table th, table td {");
           out.println("    border: 1px solid #ccc;");
           out.println("    padding: 8px;");
           out.println("    text-align: left;");
           out.println("}");

           out.println("table th {");
           out.println("    background-color: #f2f2f2;");
           out.println("}");
           out.println("</style>");


           out.println("    </tbody>");
           out.println("</table>");

           out.print("<table>\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Nome</th>\n" +
                "        <th>Telefones</th>\n" +
                "        <th>Login</th>\n" +
                "        <th>Senha</th>\n" +
                "        <th>Deletar</th>\n" +
                "        <th>Editar</th>\n" +
                "        <th colspan=2>Alterar Telefone</th>\n" +
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
                        "</td><td>" + "Telefones" +
                        "</td><td>" + u.getLogin()+
                        "</td><td> **** </td>"+
                        "<td><a>Deletar</a></td>"+
                        "<td><a>Editar</a></td>"+
                        "<td><a>Deletar telefone</a></td>" +
                        "<td><a>Adicionar telefone</a></td>" +
                        "</tr>");
        }
        out.print("    </tbody>\n" +
                "  </table>");



        out.print("<script>\n" +
                "    function deletarTelefone(usuarioId) {\n" +
                "        var telefone = prompt(\"Digite o telefone que deseja deletar:\");\n" +
                "        if (telefone !== null) {\n" +
                "            // Submeta para o servlet apagaTelefone com o parâmetro do telefone e do ID do usuário\n" +
                "            window.location.href = \"apagaTelefone?usuarioId=\" + usuarioId + \"&telefone=\" + telefone;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    function adicionarTelefone(usuarioId) {\n" +
                "        var telefone = prompt(\"Digite o telefone que deseja adicionar:\");\n" +
                "        if (telefone !== null) {\n" +
                "            // Submeta para o servlet adicionarTelefone com o parâmetro do telefone e do ID do usuário\n" +
                "            window.location.href = \"adicionarTelefone?usuarioId=\" + usuarioId + \"&telefone=\" + telefone;\n" +
                "        }\n" +
                "    }\n" +
                "</script>\n");




        out.println("</body></html>");
    }

}