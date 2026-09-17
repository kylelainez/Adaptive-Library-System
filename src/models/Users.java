package models;

import helpers.Searchaeable;
import java.util.List;

public class Users implements Searchaeable {
    private String name;
    private String userId;
    private List<Books> borrowedBooks;

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
