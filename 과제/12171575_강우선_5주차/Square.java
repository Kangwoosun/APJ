package homework5;

public class Square extends Rectangle {
	public Square(String name, double side) {
		// this will call the constructor of Rectangle
		super(name, side, side);
	}

	public String getClassName(){
		return "Square"; 
	}
	
	public double getSide() {
		return super.getWidth();
	}
	
	public void setSide(int side) {
		super.setSize(side, side);		
	}

	@Override
	public String toString() {
		return String.format("%s is a [%s], and is a [%s]",
				super.getName(), getClassName(), super.getClassName());
	}
}