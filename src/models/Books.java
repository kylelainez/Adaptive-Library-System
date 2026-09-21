package models;
import com.fasterxml.jackson.annotation.JsonProperty;
import helpers.Searchable;

import java.security.SecureRandom;

public class Books implements Searchable {
    private String title;
    private String author;
    private String genre;
    private String bookID;
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    public Books(String title, String author, String genre, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.bookID = generateID();
    }
    public Books() {
        // Jackson uses this constructor
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getBookID() { return bookID;}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean bool){
        this.isAvailable = bool;
    }

    @Override
    public boolean matches(String query) {
        query = query.toLowerCase();
        return title.toLowerCase().contains(query) || author.toLowerCase().contains(query) ||
                genre.toLowerCase().contains(query) || bookID.contains(query);
    }

    private String generateID(){
        SecureRandom random = new SecureRandom();
        StringBuilder newId = new StringBuilder(10);
        for(int i=0; i<10; i++){
            newId.append(random.nextInt(10));
        }
        return newId.toString();
    }

    public String toJson(){
    return String.format("{\"bookID\": \"%s\",\"title\": \"%s\",\"author\": \"%s\"," +
            "\"genre\": \"%s\",\"isAvailable\": %b}",
            bookID,
            title,
            author,
            genre,
            isAvailable);
    }
}
