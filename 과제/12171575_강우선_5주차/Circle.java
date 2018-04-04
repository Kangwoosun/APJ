package homework5;

public class Circle extends TwoDimensionalShape {
	public Circle(String name, double r) {
		super(name, r, r);
	}

	@Override
	// return current class name
	public String getClassName() {
		return "Circle";
	}

	public double getRadius() {
		return super.getDimension1();
	}

	public void setRadius(double r) {
		super.setDimension1(r);
		super.setDimension2(r);
	}
	public double getDiameter() {
		return super.getDimension1()*2;
	}

	public void setDiameter(double d) {
		super.setDimension1(d/2);
		super.setDimension2(d/2);
	}

	@Override
	public double getArea() {
		return Math.PI * super.getDimension1() * super.getDimension1();
	}

	@Override
	public String toString() {
		return String.format("%s is a [%s], and is a [%s]", 
				super.getName(), getClassName(), super.getClassName());
	}
}
