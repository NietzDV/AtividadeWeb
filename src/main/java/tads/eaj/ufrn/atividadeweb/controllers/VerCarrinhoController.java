package tads.eaj.ufrn.atividadeweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/verCarrinho")
public class VerCarrinhoController {

    @GetMapping
    public  void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.getWriter().println("hello from carrinho ver");

    }

}
