package tads.eaj.ufrn.atividadeweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.eaj.ufrn.atividadeweb.connection.ConectaBanco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/produto")
public class produtoController {
    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       /* String name = request.getParameter("nome");
        response.getWriter().append("Hello, ").append(name).append(".");

        Connection connection = null;
        try {
            connection = ConectaBanco.getConnection();
        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("Connection Failed! Check output console");
        }

        if (connection != null) {
            response.getWriter().append("A conexão com o banco foi realizada!");
        } else {
            response.getWriter().append("A conexão com o banco falhou!");
        }

        try {
            assert connection != null;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
