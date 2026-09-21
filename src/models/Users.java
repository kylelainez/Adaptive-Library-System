package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import helpers.Searchable;

import java.util.ArrayList;
import java.util.List;

public class Users implements Searchable {
    private String name;
    private String userId;
    @JsonProperty("borrowedBooks")
    private final List<Books> borrowedBooks;
    @JsonProperty("isAdmin")
    private boolean isAdmin;

    public Users() {
        this.borrowedBooks = new ArrayList<>();
    }

    public Users(String name, String userId, boolean isAdmin) {
        this.name = name;
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.borrowedBooks = new ArrayList<>();
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
    public void displayBorrowedBooks(){
        if (!borrowedBooks.isEmpty()){
            for (Books book : borrowedBooks){
                System.out.println("Title: "+ book.getTitle() + " Author: " + book.getAuthor()
                        + " Genre: " + book.getGenre() + "Book ID: " + book.getBookID());
            }
        }
    }

    @Override
    public boolean matches(String query) {
        return name.toLowerCase().contains(query.toLowerCase()) || userId.contains(query);
    }

    public String toJson(){
        String json =  String.format("\n{\"userId\": \"%s\", \"name\": \"%s\", \"isAdmin\": \"%b\",",
                userId,
                name,
                isAdmin);
        json = json + "\"borrowedBooks\": [";
        if(!borrowedBooks.isEmpty()){
            for (Books book : borrowedBooks){
                json = json + String.format("{\"bookId\": \"%s\", \"title\": \"%s\", \"author\": \"%s\", " +
                        "\"genre\": \"%s\", \"isAvailable\": %b},",
                        book.getBookID(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.isAvailable());
            }
        }
        json = json + "]}";
        return json;
    }
}
