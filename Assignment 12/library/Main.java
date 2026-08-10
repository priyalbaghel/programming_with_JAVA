import library.Book;

public class Main {
    public static void main(String[] args) {

        Book b = new Book(101, "Java Programming", "James Gosling", 550.00);

        System.out.println("----- Book Details -----");
        b.displayBook();
    }
}