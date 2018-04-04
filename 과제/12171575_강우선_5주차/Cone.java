package homework5;

public class Cone extends ThreeDimensionalShape{
	Cone(String name, double height, double radius){
		super(name, height, radius, 0.0);
	}
	
	public double getheight() {
		return super.getDimension1();
	}
	
	public void setheight(double height) {
		super.setDimension1(height);
	}
	
	public double getradius() {
		return super.getDimension2();
	}
	
	public void setradius(double radius) {
		super.setDimension2(radius);
	}
	
	public double getArea() {
		return Math.PI * this.getradius() * this.getradius() 
				+ Math.PI *this.getradius()* 
				Math.sqrt(this.getheight()*this.getheight()+this.getradius()*this.getradius());
	}
	
	public double getVolume() {
		return Math.PI * this.getradius() * this.getradius() * this.getheight() / 3;
	}

	public String getClassName() {
		return "Cone";
	}
	
	public String toString() {
		return String.format("%s is a %s inherited from %s class",
				super.getName(), getClassName(), super.getClassName());
	}
}
