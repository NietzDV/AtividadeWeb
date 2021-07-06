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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Controller
@RequestMapping(value = "/config")
public class CriarTable {
  final String CriarTableSQL = "CREATE TABLE produto (id integer, marca varchar(80), tipo varchar(80), estoque integer, preco float, peso integer);";



    final String intanciaSQL = "INSERT INTO produto(id, tipo, marca, estoque, peso, preco)" +
                                "VALUES (0004, 'detergente', 'IP', 45, 250, 8);";


   @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mostrarSQL = "Select * from produto";
        String name = request.getParameter("nome");
        response.getWriter().append("Hello, ").append(name).append(".");

        Connection connection = null;
        Statement st = null ;
        try {
            connection = ConectaBanco.getConnection();

        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("Connection Failed! Check output console");
        }

        if (connection != null) {
            response.getWriter().append("A conexão com o banco foi realizada!(fora do try)");
            try {
                st = connection.createStatement();
               // st.executeUpdate(CriarTableSQL);
                st.executeUpdate(intanciaSQL);
                response.getWriter().append("A conexão com o banco foi realizada! Questão 2 - OK");
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().append("A conexão com o banco falhou!" );
        }

        try {
            assert connection != null;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}

// Funçao de inserir funcionando
// Função criar table funcionando