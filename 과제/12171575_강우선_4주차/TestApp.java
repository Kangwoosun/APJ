package homework4;
import java.util.*;

public class TestApp {
	public static void main(String[] args) {

		BookShelf myShelf = new BookShelf(10); // Create a Bookshelf object with the capacity is 10 books
		Scanner scan = new Scanner(System.in); // User input
		int choice = 0; // User input option
		Book[] result = null; // Search result

		// Init the books and put in bookshelf
		myShelf.addBook(new Book("Harry Potter And The Socerer's Stone",
				new String[] { "J.K. Rowling" }, 428, 1998));
		myShelf.addBook(new Book("Contemporary Linear Algebra", 
				new String[] {"Howar Anton", "Robert C.Busby" }, 834, 2010));
		myShelf.addBook(new Book("Harry Potter And The Goblet Of Fire",
				new String[] { "J.K.Rowling", "Mary GrandPre", "Third Author" }, 752, 2002));
		myShelf.addBook(new Book("Justice:What's the rithg things to do?",
				new String[] { "Michael J. Sandel" }, 652, 2008));
		myShelf.addBook(new Book("The Lord Of The Rings Part one",
				new String[] { "J.R.R. Tolkien" }, 654, 1954));

		
		choice = 1;
		// Loop until user want to exit
		while (1<= choice && choice <= 3) {
			
			// Display options
			System.out.println("Choose 1 option to search:");
			System.out.println("1. Search by title.");
			System.out.println("2. Search by author.");
			System.out.println("3. Search by both.");
			System.out.println("4. Exit.");
			System.out.print("User input: ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				// Search by title of books
				System.out.print("Insert title keyword: ");
				scan.nextLine();
				result = myShelf.searchByTitle(scan.nextLine());
				break;
			case 2:
				// Search by authors of books
				System.out.print("Insert author keyword: ");
				scan.nextLine();
				result = myShelf.searchByAuthor(scan.nextLine());
				break;
			case 3:
				// Search by title and authors of books
				System.out.print("Insert title or author keyword: ");
				scan.nextLine();
				result = myShelf.searchByBoth(scan.nextLine());
				break;
			}
			if(choice != 4)
			{	System.out.println("-------------------------------------------");
			// Print the result
			System.out.println("Found " + result.length + " book(s)");
			for (int i = 0; i < result.length; i++) {
				System.out.println((i+1) + ". " + result[i].toString() + ".");
			}
			System.out.println("-------------------------------------------");
			}
			
		}
		
		// Exit this program
		System.out.println("Goodbye");
	}
}