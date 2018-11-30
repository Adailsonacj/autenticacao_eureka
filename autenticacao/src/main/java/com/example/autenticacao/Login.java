package com.example.autenticacao;

import com.netflix.discovery.EurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Login {

    UsuarioRepository usuarioRepository;
    private EurekaClient eurekaClient;
    UserRepositoryTest repository = new UserRepositoryTest();

    @GetMapping
    @RequestMapping("/login")
    public @ResponseBody
    ResponseEntity autenticar(@RequestParam String email, @RequestParam String senha) {
        //Método que responde à requisição do usuário de acordo com o email e senha passados nos parâmetros
        User n = new User(email, senha);
        if (repository.findUser(n)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping("/test")
    public String getInsances() {
        //Método retorna as instancias de serviços com o nome especificado.
        return String.format("Hello from '%s'!", eurekaClient.getApplication("autenticacao").getInstances());
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String insertUser(@RequestParam String email,
                      @RequestParam String senha, @RequestParam int idPessoa) {
        User n = new User(email, senha);
        usuarioRepository.save(n);
        return "Saved: id = " + n.getId();
    }
}
