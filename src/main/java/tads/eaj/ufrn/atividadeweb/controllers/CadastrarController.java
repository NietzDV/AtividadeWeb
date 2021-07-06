package tads.eaj.ufrn.atividadeweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.eaj.ufrn.atividadeweb.connection.ConectaBanco;
import tads.eaj.ufrn.atividadeweb.produtos.ProdutosLimpeza;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping(value = "/cadastro")
public class CadastrarController {


    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String intanciaSQL = "INSERT INTO produto(id, tipo, marca, estoque, peso, preco)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        String mostrarSQL = "Select * from produto";
        Connection connection = null;
        Statement st = null ;
        try {
            connection = ConectaBanco.getConnection();

        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("Connection Failed! Check output console");

        }

        if (connection != null) {
            response.getWriter().append("status:CONNECT");
            var id = request.getParameter("id");
            var tipo = request.getParameter("tipo");
            var marca = request.getParameter("marca");
            var estoque = request.getParameter("estoque");
            var peso = request.getParameter("peso");
            var preco = request.getParameter("preco");

            var produto = new ProdutosLimpeza(Integer.parseInt(id) , marca, tipo, Integer.parseInt(estoque),  Float.parseFloat(preco), Integer.parseInt(peso));
            try {
                st = connection.prepareStatement(intanciaSQL);

                ((PreparedStatement) st).setInt(1, produto.getID());
                ((PreparedStatement) st).setString(2, produto.getMarca());
                ((PreparedStatement) st).setString(3, produto.getTipo());
                ((PreparedStatement) st).setInt(4,produto.getEstoque());
                ((PreparedStatement) st).setFloat(5, (float) produto.getPreco());
                ((PreparedStatement) st).setInt(6, (int) produto.getPeso());
                response.getWriter().append("A conexão com o banco foi realizada!2");
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

