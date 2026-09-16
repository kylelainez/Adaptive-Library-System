package models;

import helpers.Searchaeable;

public class Users implements Searchaeable {
    private String name;
    private String userId;

    public Users(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean matches(String query) {
        return name.contains(query) || userId.contains(query);
    }
}
