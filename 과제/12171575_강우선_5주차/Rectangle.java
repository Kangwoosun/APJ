package homework5;

public class Rectangle extends TwoDimensionalShape {
	public Rectangle(String name, double width, double height) {
		// store width in field demension1, height in field demension2
		super(name, width, height);
	}

	public String getClassName(){
		return "Rectangle"; 
	}
	
	public double getWidth() {
		return super.getDimension1();
	}

	public double getHeight() {
		return super.getDimension2();
	}

	public void setSize(double w, double h){
		super.setDimension1(w);
		super.setDimension2(h);
	}
	
	@Override
	public double getArea() {
		return super.getDimension1() * super.getDimension2();
	}
	
	@Override
	public String toString() {
		return String.format("%s is a [%s], and is a [%s]",
				super.getName(), getClassName(), super.getClassName());
	}
}
