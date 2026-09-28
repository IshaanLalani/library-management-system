import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book class
    static class Book {
        private String title;
        private String author;
        private int bookId;
        private boolean isIssued;

        public Book(String title, String author, int bookId) {
            this.title = title;
            this.author = author;
            this.bookId = bookId;
            this.isIssued = false;
        }

        public String getTitle() {
            return title;
        }

        public int getBookId() {
            return bookId;
        }

        public boolean isIssued() {
            return isIssued;
        }

        public void issue() {
            isIssued = true;
        }

        public void returnBook() {
            isIssued = false;
        }

        public void displayInfo() {
            System.out.println("ID: " + bookId + " | " + title + " by " + author + (isIssued ? " [Issued]" : ""));
        }
    }

    // Member class
    static class Member {
        private String name;
        private int memberId;
        private ArrayList<Book> borrowedBooks;

        public Member(String name, int memberId) {
            this.name = name;
            this.memberId = memberId;
            this.borrowedBooks = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public int getMemberId() {
            return memberId;
        }

        public void borrowBook(Book book) {
            borrowedBooks.add(book);
        }

        public void returnBook(Book book) {
            borrowedBooks.remove(book);
        }

        public void displayBorrowedBooks() {
            if (borrowedBooks.isEmpty()) {
                System.out.println(name + " has not borrowed any books.");
            } else {
                System.out.println(name + "'s Borrowed Books:");
                for (Book book : borrowedBooks) {
                    System.out.println("- " + book.getTitle());
                }
            }
        }
    }

    // Library class
    static class Library {
        private ArrayList<Book> books;
        private ArrayList<Member> members;

        public Library() {
            books = new ArrayList<>();
            members = new ArrayList<>();
            preloadBooks();
        }

        private void preloadBooks() {
            books.add(new Book("Harry Potter", "J.K. Rowling", 101));
            books.add(new Book("The Alchemist", "Paulo Coelho", 102));
            books.add(new Book("1984", "George Orwell", 103));
            books.add(new Book("To Kill a Mockingbird", "Harper Lee", 104));
            books.add(new Book("The Hobbit", "J.R.R. Tolkien", 105));
            books.add(new Book("Pride and Prejudice", "Jane Austen", 106));
            books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 107));
            books.add(new Book("Moby Dick", "Herman Melville", 108));
            books.add(new Book("War and Peace", "Leo Tolstoy", 109));
            books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 110));
            books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 111));
            books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 112));
            books.add(new Book("Animal Farm", "George Orwell", 113));
            books.add(new Book("The Da Vinci Code", "Dan Brown", 114));
            books.add(new Book("The Kite Runner", "Khaled Hosseini", 115));
            books.add(new Book("The Fault in Our Stars", "John Green", 116));
            books.add(new Book("Percy Jackson", "Rick Riordan", 117));
            books.add(new Book("A Game of Thrones", "George R.R. Martin", 118));
            books.add(new Book("Inferno", "Dan Brown", 119));
            books.add(new Book("Life of Pi", "Yann Martel", 120));
        }

        public void addMember(Member member) {
            members.add(member);
        }

        public void viewAvailableBooks() {
            System.out.println("\nAvailable Books:");
            for (Book book : books) {
                if (!book.isIssued()) {
                    book.displayInfo();
                }
            }
        }

        public void issueBook(int bookId, int memberId) {
            Book book = findBook(bookId);
            Member member = findMember(memberId);

            if (book == null) {
                System.out.println("Book not found!");
                return;
            }
            if (member == null) {
                System.out.println("Member not found!");
                return;
            }
            if (book.isIssued()) {
                System.out.println("Sorry, the book is already issued.");
            } else {
                book.issue();
                member.borrowBook(book);
                System.out.println("Book issued successfully to " + member.getName());
            }
        }

        public void returnBook(int bookId, int memberId) {
            Book book = findBook(bookId);
            Member member = findMember(memberId);

            if (book == null || member == null) {
                System.out.println("Book or Member not found!");
                return;
            }

            if (!book.isIssued()) {
                System.out.println("This book was not issued.");
            } else {
                book.returnBook();
                member.returnBook(book);
                System.out.println("Book returned successfully by " + member.getName());
            }
        }

        private Book findBook(int bookId) {
            for (Book book : books) {
                if (book.getBookId() == bookId) {
                    return book;
                }
            }
            return null;
        }

        private Member findMember(int memberId) {
            for (Member member : members) {
                if (member.getMemberId() == memberId) {
                    return member;
                }
            }
            return null;
        }

        public void viewIssuedBooks() {
            System.out.println("\nIssued Books:");
            for (Book book : books) {
                if (book.isIssued()) {
                    book.displayInfo();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Member member = new Member(name, memberId);
        library.addMember(member);

        int choice;
        do {
            System.out.println("\n----- Library Menu -----");
            System.out.println("1. View Available Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. View Issued Books");
            System.out.println("5. View My Borrowed Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.viewAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = scanner.nextInt();
                    library.issueBook(issueBookId, memberId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    library.returnBook(returnBookId, memberId);
                    break;
                case 4:
                    library.viewIssuedBooks();
                    break;
                case 5:
                    member.displayBorrowedBooks();
                    break;
                case 6:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}