package accounts;

import models.Users;

import java.security.SecureRandom;

public class Register {
    private final String adminPassword = "AdminSecretPassword_123";
    private boolean isAdmin;

    public Register(String name, String adminPassword, RegisteredUsers list){
        String userId = generateID();
        if (!list.check(name)){
            Users newUser = new Users(name, userId, adminPassword.equals(this.adminPassword));
            list.add(newUser);
            System.out.println("New User created!\n" +
                    "Name: " + newUser.getName() +
                    "\nUser ID: " + newUser.getUserId() +
                    "\nAdmin? " + newUser.isAdmin());
        } else{
            System.out.println("User already exist");
        }
    }

    private String generateID(){
        SecureRandom random = new SecureRandom();
        StringBuilder newId = new StringBuilder(10);
        for(int i=0; i<10; i++){
            newId.append(random.nextInt(10));
        }
        return newId.toString();
    }
}
