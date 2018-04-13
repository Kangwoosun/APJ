package homework6;

public abstract class Item implements ForSale {
	private String itemID;
	private int importPrice;
	
	public Item(String id, int price) {
		this.itemID = id;
		this.importPrice = price;
	}
	public int getImportPrice() {
		return this.importPrice;
	}
	public String getItemID() {
		return this.itemID;
	}
	public abstract String getInfo();

}
