package library;
import java.util.Scanner;
import java.util.Random;

public class Library {
	private String libraryName;
	private Book[] bookList = new Book[MAX_NUMBER_BOOKS];
	private static int numberOfBooks = 0;
	public static final int MAX_NUMBER_BOOKS = 100;
	
	public Library(String libraryName) {
		this.libraryName = libraryName;
	}
	
	public void addNewBook() {
		if(numberOfBooks == MAX_NUMBER_BOOKS) {
			System.out.println("Book list is full!");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("2, Add new book "
				+ "\n------------------------- "
				+ "\nEnter book's information: ");
		
		System.out.print("(1)Book ID: ");
		int bookID = sc.nextInt();
			for(Book book: bookList) {
				if(book == null) {
					break;
				}
				if(bookID == book.getBookID()) {
					System.out.println("BookID is exist! Try again.");
					this.addNewBook();
					return;
				}
			}
		sc.nextLine();
		System.out.print("\n(2)Book Title: ");
		String bookTitle = sc.nextLine();
		
		System.out.print("\n(3)Amount: ");
		int amount = sc.nextInt(); 
		bookList[numberOfBooks] = new Book(bookID, bookTitle, amount);
		numberOfBooks++;
		System.out.println("Successful!");
	}
	public boolean findBook(int bookID) {
		for(Book book : bookList) {
			if(book == null) continue;
			if(bookID == book.getBookID()) {
				book.showBookInfo();
				return true;
			}
		}
		System.out.println("Don't have this book!");
		return false;
	}
	public void borrowBook(int bookID) {
		for(Book book : bookList) {
			if(book == null) continue;
			if(bookID == book.getBookID() && book.getAvailable() > 0) {
				book.showBookInfo();
				book.setAvailable(book.getAvailable() - 1);
				book.showBookInfo();
				return;
			}
		}
		System.out.println("Don't have this book!");
	}
	public void returnBook(int bookID) {
		for(Book book : bookList) {
			if(book == null) continue;
			if(bookID == book.getBookID()) {
				book.setAvailable(book.getAvailable() + 1);
				if(book.getAvailable() > book.getAmount()) {
					System.out.println("Available > Amount");
					return;
				}
				System.out.println("The book is returned successfully!");
				book.showBookInfo();		
				return;
			}
		}
	}
	public void showLibraryInfo() {
		System.out.println("Library Name: " + libraryName
				+ "\nNumber of books: " + numberOfBooks
				+ "\nBook list: ");
		for(Book book : bookList) {
			if(book == null) continue;
			book.showBookInfo();
		}
	}
	
	public boolean findBook(String keyword) {
		boolean bool = false;
		for(Book book : bookList) {
			if(book == null) continue;
			if(book.getBookTitle().toLowerCase().indexOf(keyword.toLowerCase()) != -1) {
				book.showBookInfo();
				bool = true;
			}
		}
		return bool;
	}
}
