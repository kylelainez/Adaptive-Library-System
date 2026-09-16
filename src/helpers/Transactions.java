package helpers;
import java.time.LocalDateTime;

import models.Books;
import models.Users;

public abstract class Transactions {
    private Books book;
    private Users user;
    private LocalDateTime transactionDate;

    public Transactions(Books book, Users user, LocalDateTime transactionDate) {
        this.book = book;
        this.user = user;
        this.transactionDate = transactionDate;
    }
}
