package accounts;

import database.FileManagerAccounts;
import models.Users;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {
    private List<Users> usersList;

    public RegisteredUsers() {
        usersList = new ArrayList<>();
    }

    public void loadUsers(){
        FileManagerAccounts fileManagerAccounts = new FileManagerAccounts();
        usersList = fileManagerAccounts.loadDatabase();
    }

    public void add(Users user){
        usersList.add(user);
        FileManagerAccounts fileManagerAccounts = new FileManagerAccounts();
        fileManagerAccounts.saveDatabase(usersList);
        System.out.println("User has been added");
    }

    public boolean check(String name){
        if(usersList.isEmpty()){
            System.out.println("No registered users yet.");
            return false;
        }
        for (Users user : usersList){
            if (name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }
    public Users login(String name, String userId){
        if(usersList.isEmpty()){
            System.out.println("No registered users yet.");
            return null;
        }
        for (Users user : usersList){
             if (name.equals(user.getName()) && userId.equals(user.getUserId())){
                 System.out.println("Successfully logged in!");
                 return user;
             }
        }
        System.out.print("User is not in the system.");
        return null;
    }

}
