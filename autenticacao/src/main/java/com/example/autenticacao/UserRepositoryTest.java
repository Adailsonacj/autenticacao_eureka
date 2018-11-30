package com.example.autenticacao;


import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest {
    List<User> users = new ArrayList();

    public UserRepositoryTest() {
        users.add(new User("adailsonacj@live.com", "adailson123"));
        users.add(new User("lucas@gmail.com", "queviagem123"));
    }

    public boolean findUser(User user) {
        boolean find = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail()) && users.get(i).getSenha().equals(user.getSenha())) {
                find = true;
            }
        }
        return find;
    }
}