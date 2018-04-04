package homework5;

/**
 * Create class of 2Dshape and can be subclassed.
 */
public abstract class TwoDimensionalShape {
	private String name;
	private double dimension1;
	private double dimension2;

	// constructor
	public TwoDimensionalShape(String name, double d1, double d2) {
		this.name = name;
		this.dimension1 = d1;
		this.dimension2 = d2;
	}

	// set methods for dimension 1
	public void setDimension1(double d) {
		dimension1 = d;
	}

	// set methods for dimension 2
	public void setDimension2(double d) {
		dimension2 = d;
	}

	// get name and class name
	public String getClassName() {
		return "2D Shape";
	}

	public String getName() {
		return name;
	}

	// get methods for dimension 1
	public double getDimension1() {
		return dimension1;
	}

	// get methods for dimension 2
	public double getDimension2() {
		return dimension2;
	}

	/**
	 * don't know the kind of current shape so return 0 only can be implement in subclass
	 * @return the area of the shape
	 */
	public abstract double getArea();
	
}
