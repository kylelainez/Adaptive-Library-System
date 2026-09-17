package models;
import helpers.Searchaeable;

public class Books implements Searchaeable {
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Books(String title, String author, String genre, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean bool){
        this.isAvailable = bool;
    }

    @Override
    public boolean matches(String query) {
        return title.contains(query) || author.contains(query) || genre.contains(query);
    }
}
