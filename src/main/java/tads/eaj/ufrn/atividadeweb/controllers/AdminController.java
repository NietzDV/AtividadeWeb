package tads.eaj.ufrn.atividadeweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.getWriter().println("admin hello");
        var writer = response.getWriter();
        response.setContentType("text/html");
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1 style=\"text-align:center;\">Cadastrar</h1>\n" +
                "<form method=\"post\" action=\"/cadastra\">\n" +
                "    ID:<input type=\"number\" name=\"id\"/> </br>\n" +
                "    tipo:<input type=\"text\" name=\"tipo\"/>\n" +
                "    marca:<input type=\"text\" name=\"marca\"/>\n" +
                "    estoque:<input type=\"number\" name=\"estoque\"/>\n" +
                "    peso:<input type=\"number\" name=\"peso\"/>\n" +
                "    preco:<input type=\"number\" name=\"preco\"/>\n" +
                "    <button>concluir</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dataFormat = data.format(format);
        Cookie visit = new Cookie("visita", dataFormat);
        visit.setMaxAge(60*60*24);
        response.addCookie(visit);

    }

}
