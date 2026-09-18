package models;

import helpers.Searchaeable;
import java.util.List;

public class Users implements Searchaeable {
    private final String name;
    private final String userId;
    private List<Books> borrowedBooks;
    private final boolean isAdmin;

    public Users(String name, String userId, boolean isAdmin) {
        this.name = name;
        this.userId = userId;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void addBooks(Books book){
        borrowedBooks.add(book);
    }

    public String removeBooks(Books book){
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            return ("Book " + book.getTitle() + " has been return by " + name);
        }
        return("Book is not borrowed by the User");
    }


    @Override
    public boolean matches(String query) {
        return name.contains(query) || userId.contains(query);
    }
}
