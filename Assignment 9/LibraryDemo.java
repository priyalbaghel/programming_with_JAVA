import java.util.Scanner;

class Book {
    final String isbn; // final - cannot be changed once assigned
    String title;
    String author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBookDetails() {
        System.out.println("\n----- Book Details -----");
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Enter Book Details ---");
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Book book = new Book(isbn, title, author, price);
        book.displayBookDetails();

        sc.close();
    }
}