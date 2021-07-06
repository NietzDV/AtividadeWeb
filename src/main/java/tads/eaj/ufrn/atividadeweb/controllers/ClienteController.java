package tads.eaj.ufrn.atividadeweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tads.eaj.ufrn.atividadeweb.connection.ConectaBanco;
import tads.eaj.ufrn.atividadeweb.produtos.ProdutosLimpeza;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "cliente")
public class ClienteController {

    @GetMapping
    public void listaProdutos(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.getWriter().println("cliente hello");
        String SeletorSQL = "SELECT * FROM produto";
        response.setContentType("text/html");
        Connection connection = null;
        Statement st = null;
        ResultSet result = null;
        HttpSession session = request.getSession();
        var writer = response.getWriter();

        ArrayList<ProdutosLimpeza> produtosLimpezas = new ArrayList<>();
        ArrayList<ProdutosLimpeza> carrinho = (ArrayList<ProdutosLimpeza>) session.getAttribute("carrinho");
        try {
            connection = ConectaBanco.getConnection();
        } catch (SQLException | URISyntaxException ex) {
            writer.append("Connection Failed! Check output console");
        }

        if (connection != null) {
            writer.append("A conexão com o banco foi realizada!");
            st = connection.createStatement();
            result = st.executeQuery(SeletorSQL);

            while(result.next()){
                produtosLimpezas.add(new ProdutosLimpeza(
                        result.getInt("ID"),
                        result.getString("marca"),
                        result.getString("tipo"),
                        result.getInt("estoque"),
                        result.getFloat("preco"),
                        result.getInt("peso")));


            }

            connection.close();
            st.close();
            result.close();

        } else {
            writer.append("A conexão com o banco falhou!");
        }

        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Cliente</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"text-align:center;\">Lista produtos</h1>\n" +
                "<table border=\"1\">\n" +
                "    <tr>\n" +
                "        <th>id</th>\n" +
                "        <th>Marca</th>\n" +
                "        <th>Tipo</th>\n" +
                "        <th>Estoque</th>\n" +
                "        <th>Preco</th>\n" +
                "        <th>Peso</th>\n" +
                "        <th>Carrinho</th>\n" +
                "    </tr>");
        for(ProdutosLimpeza produtosLimpeza : produtosLimpezas){
            writer.append("<tr>");
            writer.append("<td>"+ produtosLimpeza.getID()+"</td>");
            writer.append("<td>"+ produtosLimpeza.getTipo()+"</td>");
            writer.append("<td>"+ produtosLimpeza.getMarca()+"</td>");
            writer.append("<td>"+ produtosLimpeza.getEstoque()+"</td>");
            writer.append("<td>"+ produtosLimpeza.getPreco()+"R$"+"</td>");
            writer.append("<td>"+ produtosLimpeza.getPeso()+"</td>");
            writer.append("<td><a  href=\"/adicionarCarrinho?Id="+produtosLimpeza.getID()+"\">Adicionar</a></td>");
            writer.append("</tr>");
        }
        writer.append("</table>\n" +
                "<a href=\"/verCarrinho\">Ver Carrinho</a> \n" +
                "</body>\n" +
                "</html>");
        try {
            assert connection != null;
            connection.close();
            st.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

