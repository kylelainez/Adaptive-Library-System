import accounts.Login;
import accounts.Register;
import accounts.RegisteredUsers;
import helpers.BookList;
import helpers.BorrowTransaction;
import helpers.ReturnTransaction;
import models.Books;
import models.Users;

import java.util.Scanner;

public class LibrarySystem {
    static RegisteredUsers userList = new RegisteredUsers();
    static BookList bookList = new BookList();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        userList.loadUsers();
        bookList.loadBooks();
        Users user = null;
        while (user == null) {
            user = userService();
        }
        bookService(user);

    }

    private static void bookService(Users user){
        int userInput;
        while(true){
            System.out.println("""
                \nPlease select transaction to complete:
                1.) Borrow Book
                2.) Return Book
                3.) Search Book
                4.) Display Books
                5.) Add Book to Library (Requires Admin)
                6.) Exit""");
            userInput = input.nextInt();
            input.nextLine();
            if (userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5 || userInput == 6){
                if (userInput == 1){
                    // Borrow Book
                    System.out.print("Please enter the book Id you want to borrow.");
                    String bookId = input.nextLine();
                    Books borrowedBook = bookList.getBook(bookId);
                    if( borrowedBook != null ){
                        if(!borrowedBook.isAvailable()){
                            continue;
                        }
                        BorrowTransaction borrowTransaction = new BorrowTransaction(borrowedBook, user);
                        System.out.println(borrowTransaction.execute());
                    }else{
                        System.out.println("Error: Book does not exist");
                    }
                } else if (userInput == 2) {
                    // Return Book
                    System.out.println("Please enter the book Id you want to return. ");
                    user.displayBorrowedBooks();
                    System.out.print("Book Id: ");
                    String bookId = input.nextLine();
                    Books returnedBook = bookList.getBook(bookId);
                    if (returnedBook != null){
                        ReturnTransaction returnTransaction = new ReturnTransaction(returnedBook, user);
                        System.out.println(returnTransaction.execute());
                    }else{
                        System.out.println("Error: Book does not exist");
                    }

                }else if (userInput == 3){
                    //Search Book
                    System.out.print("Please enter search query: ");
                    String query = input.nextLine();
                    bookList.searchBooks(query);
                } else if (userInput == 4){
                    bookList.displayBooks();
                } else if (userInput == 5){
                    if(user.isAdmin()){
                        // Add book
                        System.out.println("Please enter book details to add:");
                        System.out.print("Title: ");
                        String title = input.nextLine();
                        System.out.print("Author: ");
                        String author = input.nextLine();
                        System.out.print("Genre: ");
                        String genre = input.nextLine();
                        boolean isAvailable = true;
                        bookList.addBook(new Books(title,author,genre,isAvailable));
                    }else{
                        System.out.println("User not an admin, Please try again");
                    }
                }else{
                    break;
                }
            }else{
                System.out.println("Please try again.");
            }
        }
    }

    private static Users userService(){
        Users loggedIn = null;
        int userInput;
        while (loggedIn == null) {
            System.out.print("""
                Welcome to the Library System:
                1.) Login
                2.) Register
                Select Option:\s""");
            userInput = input.nextInt();
            if (userInput == 1 || userInput == 2) {
                if (userInput == 1) {
                    Login login = new Login();
                    System.out.print("Please enter your name:");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.print("Please enter your ID:");
                    String userId = input.nextLine();
                    loggedIn =  login.authenticate(name,userId, userList);
                }else{
                    System.out.println("Register form: ");
                    System.out.print("Please enter your name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.print("Please enter admin password: (Leave blank if not admin)");
                    String adminPassword = input.nextLine();
                    new Register(name, adminPassword, userList);
                }
            } else {
                System.out.println("Please try again.");
            }
        }
        return loggedIn;
    }
}
