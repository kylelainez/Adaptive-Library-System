package helpers;

import database.FileManagerBooks;
import models.Books;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Books> bookList;

    public BookList(){
        bookList = new ArrayList<>();
    }

    public void loadBooks(){
        FileManagerBooks fileManagerBooks = new FileManagerBooks();
        bookList = fileManagerBooks.loadDatabase();
    }
    public void addBook(Books book){
        if(book != null){
            bookList.add(book);
            System.out.println("Book has been added.");
            FileManagerBooks fileManagerBooks = new FileManagerBooks();
            fileManagerBooks.saveDatabase(bookList);
        }
    }
    public void displayBooks(){
        if(!bookList.isEmpty()){
            for (Books book : bookList){
                System.out.println("Title: "+ book.getTitle() + " Author: " + book.getAuthor()
                        + " Genre: " + book.getGenre() + "Book ID: " + book.getBookID() + " Available? "
                        + book.isAvailable());
            }
        }else{
            System.out.println("Book list is empty.");
        }
    }

    public Books getBook(String bookId){
        if (!bookList.isEmpty()) {
            for (Books book : bookList) {
                if (book.getBookID().matches(bookId)){
                    return book;
                }
            }
        }
        return null;
    }
    public void searchBooks(String query){
        System.out.println("Search Results");
        if (!bookList.isEmpty()) {
            for (Books book : bookList) {
                if (book.matches(query)){
                    System.out.println("Title: "+ book.getTitle() + " Author: " + book.getAuthor()
                            + " Genre: " + book.getGenre() + "Book ID: " + book.getBookID() + " Available? "
                            + book.isAvailable());
                }
            }
        }
    }
}
