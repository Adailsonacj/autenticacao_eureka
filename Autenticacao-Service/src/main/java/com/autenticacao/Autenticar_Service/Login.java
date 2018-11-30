package com.autenticacao.Autenticar_Service;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class Login {

    //UsuarioRepository usuarioRepository;
    private EurekaClient eurekaClient;
    @Value("${server.port}")
    private int porta;
    UserRepositoryTest repository = new UserRepositoryTest();

    @GetMapping
    @RequestMapping("/login")
    public @ResponseBody
    String autenticar(@RequestParam String email, @RequestParam String senha) {
        //Método que responde à requisição do usuário de acordo com o email e senha passados nos parâmetros
        User n = new User(email, senha);
        if (repository.findUser(n)) {
            return "Usuário logado com serviço da porta " + porta;
        }
        return "Usuário não encontrado na base de dados.";
    }

    @RequestMapping("/test")
    public String getInsances() {
        //Método retorna as instancias de serviços com o nome especificado.
        return String.format("Hello from '%s'!", eurekaClient.getApplication("autenticacao").getInstances());
    }
}
