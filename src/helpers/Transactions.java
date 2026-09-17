package helpers;
import java.time.LocalDateTime;

import models.Books;
import models.Users;

public abstract class Transactions {
    protected Books book;
    protected Users user;
    private LocalDateTime transactionDate;

    public Transactions(Books book, Users user) {
        this.book = book;
        this.user = user;
        this.transactionDate = LocalDateTime.now();
    }

    public abstract String execute();
}
