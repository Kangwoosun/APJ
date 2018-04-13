package homework6;

public class Movie extends Item {
	private String movieTitle;
	private int pubYear;
	
	Movie(String id, int price, String title, int year){
		super(id, price);
		this.movieTitle = title;
		this.pubYear = year;
	}
	
	public String getTitle() {
		return this.movieTitle;
	}
	
	public int getPublishYear() {
		return this.pubYear;
	}
	
	public int getSalePrice() {
		if((2018-this.getPublishYear()) <= 1)
			return 2*super.getImportPrice();
		else
			return super.getImportPrice()/2;
	}
	
	public String getInfo() {
		return this.getTitle();
	}
}
