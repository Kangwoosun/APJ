package homework5;

public class Sphere extends ThreeDimensionalShape{
	Sphere(String name, double radius){
		super(name, radius, radius, radius);
	}
	
	
	public double getradius() {
		return this.getDimension2();
	}
	
	public void setradius(double radius) {
		this.setDimension2(radius);
	}
	
	public double getArea() {
		return Math.PI * 4 * this.getradius()* this.getradius();
	}
	
	public double getVolume() {
		return Math.PI * 4 * this.getradius()* this.getradius() * this.getradius() /3;
	}

	public String getClassName() {
		return "Sphere";
	}
//	myCube is a Cube inherited from xxx class.
	public String toString() {
		return String.format("%s is a %s inherited from %s class",
				super.getName(), getClassName(), super.getClassName());
	}
}
