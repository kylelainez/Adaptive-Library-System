package models;
import helpers.Searchaeable;

public class Books implements Searchaeable {
    private String title;
    private String author;
    private String genre;
    private String isAvailable;

    public Books(String title, String author, String genre, String isAvailable) {
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

    public String getIsAvailable() {
        return isAvailable;
    }

    @Override
    public boolean matches(String query) {
        return title.contains(query) || author.contains(query) || genre.contains(query);
    }
}
