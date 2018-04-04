package homework5;

public abstract class ThreeDimensionalShape extends TwoDimensionalShape{
	private double dimension3;
	
	public String getClassName() {
		return "3D Shape";
	}
	public ThreeDimensionalShape(String name, double d1, double d2, double d3){
		super(name, d1, d2);
		this.dimension3 = d3;
	}
	public void setDimension3(double d3) {
		this.dimension3 = d3;
	}
	
	public double getDimension3() {
		return this.dimension3;
	}
	
	public abstract double getArea();
	public abstract double getVolume();
	
}
