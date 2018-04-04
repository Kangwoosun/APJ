package homework5;

public class Cube extends ThreeDimensionalShape{
	
	Cube(String name, double side){
		super(name, side, side, side);
	}
	
	public double getside() {
		return this.getDimension1();
	}
	
	public void setside(double side) {
		this.setDimension1(side);
	}
	
	public double getArea() {
		return 6 * this.getside() * this.getside();
	}
	
	public double getVolume() {
		return this.getside() * this.getside() * this.getside();
	}

	public String getClassName() {
		return "Cube";
	}
	
	public String toString() {
		return String.format("%s is a %s inherited from %s class",
				super.getName(), getClassName(), super.getClassName());
	}
	
}
