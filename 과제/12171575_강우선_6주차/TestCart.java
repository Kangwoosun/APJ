package homework6;

public class TestCart {

	public static void main(String[] args) {
		// create Cart
		Cart myCart = new Cart("Me");
		
		//create the items and add into cart
		myCart.addItem(new CD("CD001",10600,"Alive","Big Bang",2018));
		myCart.addItem(new Movie("MV010",14200,"Interstellar",2017));
		myCart.addItem(new CD("CD007",12500,"To anyone","2NE1",2017));
		myCart.addItem(new Movie("MV002",11000,"Lord of the ring",2010));
		
		//print Receipt
		myCart.printReceipt();
	}

}