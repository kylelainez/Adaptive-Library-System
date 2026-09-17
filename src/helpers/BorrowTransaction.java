package helpers;

import models.Users;
import models.Books;

public class BorrowTransaction extends Transactions{
    public BorrowTransaction(Books book, Users user){
        super(book, user);
    }

    @Override
    public String execute(){
        if(!book.isAvailable()){
            return "Book is not available.";
        }
        book.setAvailability(false);
        user.addBooks(book);
        return ("Book: " + book.getTitle() + " has been borrowed by: " + user.getName());
    }
}
