package accounts;

import models.Users;

public class Login{
    public Users authenticate(String name, String userId, RegisteredUsers list){
        return list.login(name, userId);
    }
}
