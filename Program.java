package library;
import java.util.Scanner;

public class Program {
	private static int option;
	public static void showMenu() {
		System.out.print(
			"======== Main menu ========\n" +
			"1, Show library infomation\n" +
			"2, Add new book\n" +
			"3, Find book\n" +
			"4, Borrow a book\n" +
			"5, Return a book\n" +
			"6, Exit\n" +
			"===========================\n" +
			"Enter menu ID (1-6):  "
		);
	}
	public static void askOption() {
		Scanner sc = new Scanner(System.in);
		option = sc.nextInt();
	}
	public static void chooseOption(Library library) {
		Scanner sc = new Scanner(System.in);
		switch(option) {
		case 1:
			library.showLibraryInfo();
			showMenu();
			askOption();
			chooseOption(library);
		case 2:
			library.addNewBook();
			showMenu();
			askOption();
			chooseOption(library);
		case 3:{
			System.out.print("3. Find book\n" + "--------------------\n" + "Enter book's ID :  ");
			int bookID = sc.nextInt();
			library.findBook(bookID);
			showMenu();
			askOption();
			chooseOption(library);
		}
		case 4:{
			System.out.print("4. Borrow a book\n" + "--------------------\n" + "Enter book's ID:  ");
			int bookID = sc.nextInt();
			library.borrowBook(bookID);
			showMenu();
			askOption();
			chooseOption(library);
		}
		case 5:{
			System.out.print("5. Return a book\n" + "--------------------\n" + "Enter book's ID:  ");
			int bookID = sc.nextInt();
			library.returnBook(bookID);
			showMenu();
			askOption();
			chooseOption(library);
		}
		case 6:
			System.out.println("Exit.");
			return;
		default:
			System.out.println("Error! You wrote wrong!");
			showMenu();
			askOption();
			chooseOption(library);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library("Quy Library");
		showMenu();
		askOption();
		chooseOption(library);
	}
}
