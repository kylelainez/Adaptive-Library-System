package accounts;

import models.Users;

public class Login{
    public Users authenticate(String name, String userId){
        RegisteredUsers list = new RegisteredUsers();
        return list.login(name, userId);
    }
}
