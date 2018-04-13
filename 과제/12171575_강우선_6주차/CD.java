package homework6;

public class CD extends Item {
	private String cdTitle;
	private String cdArtist;
	private int pubYear;
	
	CD(String id, int price, String title, String artist, int year){
		super(id, price);
		this.cdTitle = title;
		this.cdArtist = artist;
		this.pubYear = year;
	}
	
	public String getTitle() {
		return this.cdTitle;
	}
	
	public String getArtist() {
		return this.cdArtist;
	}
	
	public int getPublishYear() {
		return this.pubYear;
	}
	
	public int getSalePrice() {
		if((2018-this.pubYear) <= 1)
			return (int)(1.5 * super.getImportPrice());
		else if((2018-this.getPublishYear()) <= 2)
			return super.getImportPrice();
		else
			return (int)0.7 * super.getImportPrice();
	}
	
	@Override
	public String getInfo() {
		return this.getTitle() + " - " + this.getArtist();
	}
	
}
