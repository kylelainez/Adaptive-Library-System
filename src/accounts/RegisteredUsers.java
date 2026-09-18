package accounts;

import models.Users;

import java.util.List;

public class RegisteredUsers {
    private List<Users> usersList;

    public void add(Users user){
        usersList.add(user);
        System.out.println("User has been added");
    }

    public boolean check(String name){
        for (Users user : usersList){
            return (name.equals(user.getName()));
        }
        return false;
    }
    public Users login(String name, String userId){
        for (Users user : usersList){
             if (name.equals(user.getName()) && userId.equals(user.getUserId())){
                 return user;
             }
        }
        System.out.print("User is not in the system.");
        return null;
    }

}
