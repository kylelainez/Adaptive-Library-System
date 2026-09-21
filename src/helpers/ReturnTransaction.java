package helpers;

import models.Users;
import models.Books;

public class ReturnTransaction extends Transactions{
    public ReturnTransaction(Books book, Users user){
        super(book, user);
    }

    @Override
    public String execute(){
        if(book.isAvailable()){
            return "Book is in the library.";
        }
        book.setAvailability(true);
        user.removeBooks(book);
        return "Book has been returned";
    }
}
