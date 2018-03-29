package homework4;

public class BookShelf {
	private Book[] book = null;
	private int size;
	private int booknum = 0;
	
	public BookShelf(int size) {
		book = new Book[size];
		this.size = size;
	}
	
	public void addBook(Book newbook) {
		if(size > booknum){
//			String[] S = newbook.getauthor();
//			book[booknum].setauthor(S);
//			book[booknum].setpage(newbook.getpage());
//			book[booknum].setpublished_year(newbook.getpublished_year());
//			book[booknum].settitle(newbook.gettitle());
			book[booknum] = newbook;
			this.booknum++;
		}
		else
			System.out.println("BookShelf is full");
	}
	
	public Book[] searchByTitle(String substring) {
		int search[] = new int[this.size];
		int count = 0;
		
		for(int i =0; i<this.booknum; i++)
			if(book[i].gettitle().contains(substring))
				{
					search[count] = i+1;
					count++;
				}
		Book[] result = new Book[count];
		for(int i=0; search[i] != 0; i++) {
			result[i] = book[search[i] - 1];
		}
		return result;
			
	}
	
	public Book[] searchByAuthor(String substring) {
		int search[] = new int[this.size];
		int count =0;
		
		for(int i =0; i<this.booknum; i++)
			for(int j =0; j<book[i].getauthor_num();j++)
				if(book[i].getauthor()[j].contains(substring))
					{
						search[count] = i+1;
						count++;
						break;
					}
		Book[] result = new Book[count];
		for(int i=0; search[i] != 0; i++) {
			result[i] = book[search[i] - 1];
		}
		return result;
	}
	
	public Book[] searchByBoth(String substring) {
		int search[] = new int[this.size];
		int count = 0;
		
		for(int i =0; i<this.booknum; i++)
			{
				if(book[i].gettitle().contains(substring))
						{
							search[count] = i+1;
							
							count++;
						}
					
				else
					for(int j =0; j<book[i].getauthor_num();j++)
						if(book[i].getauthor()[j].contains(substring))
							{
								search[count] = i+1;
								
								count++;
								break;
							}
			}
		Book[] result = new Book[count];
		for(int i = 0; search[i] != 0; i++)
			result[i] = book[search[i]-1];

		return result;
	}
}
