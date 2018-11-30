package com.autenticacao.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginClient {
    @Autowired
    private RestTemplate template;

    @GetMapping
    @RequestMapping("/login")
    public @ResponseBody
    String autenticar(@RequestParam String email, @RequestParam String senha) {
//        Servidor irá balancear a chamada a serviços, o cliente procura por um serviço com nome especificado
        return template.getForObject("http://AUTENTICACAO/login?email=" + email + "&&senha=" + senha, String.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
