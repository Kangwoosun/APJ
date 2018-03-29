package homework4;

public class Book {
	private String title;
	private String[] author;
	private int page;
	private int published_year;
	private int author_num;
	
	public Book(String title, String[] author, int page, int published_year){
		this.title = title;
		
//		if(author.length <= 3)
//			for(int i =0; i< author.length; i++)
//				if(author[i]!=null)				this.author[i] = author[i];
//				else 							this.author[i] = "";
		this.author = author;
		this.author_num = author.length;
		this.page = page;
		this.published_year = published_year;
	}
	
	public void settitle(String title) {
		this.title = title;
	}
	public String gettitle() {
		return this.title;
	}
	public void setauthor(String[] author) {
//		if(author.length <= 3)
//			for(int i =0; i< author.length; i++)
//				if(author[i]!=null)				this.author[i] = author[i];
//				else 							this.author[i] = "";
		this.author = author;
		this.author_num = author.length;
	//	this.author = author;
	}
	public String[] getauthor() {
		return this.author;
	}
	public void setpage(int page) {
		this.page = page;
	}
	public int getpage() {
		return this.page;
	}
	public void setpublished_year(int published_year) {
		this.published_year = published_year;
	}
	public int getpublished_year() {
		return this.published_year;
	}
	public int getauthor_num() {
		return this.author_num;
	}
	public String toString() {
		String returnauthor = "";
		for(int i = 0; i<this.author_num; i++) {
			if(i != this.author_num-1)
				returnauthor += this.author[i]+", ";
			else
				returnauthor += this.author[i];
		}
		return this.title + " - " +returnauthor + " - "+ String.valueOf(this.page) + " pages - " + String.valueOf(this.published_year);
		// Harry Potter And The Sorcerer's Stone - J.K.Rowling - 428 pages - 1998.
	}

}
