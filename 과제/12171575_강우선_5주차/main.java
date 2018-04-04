package homework5;

public class main {
	public static void main(String[] args) {
		
//		myCube is a Cube inherited from xxx class.
//		side = 0.4,
//		surface area = 0.96,
//		volume = 0.064.
		
//		mySphere is a Sphere inherited from zzz class.
//		radius = 0.3
//		surface area = 1.131
//		volume = 0.113.
		
//		myCone is a Cone inherited from yyy class.
//		height = 1.2,
//		radius = 0.7,
//		surface area = 4.594,
//		volume = 0.616.
		
		Cube cub1 = new Cube("myCube", 0.4);
		Sphere sph1 = new Sphere("myShpere", 0.3);
		Cone con1 = new Cone("myCone", 1.2, 0.7);
		
		System.out.println(cub1.toString()+".");
		System.out.printf("side = %.2f\n", cub1.getside());
		System.out.printf("surface area = %.3f\n", cub1.getArea());
		System.out.printf("volume = %.3f\n\n", cub1.getVolume());
		
		System.out.println(sph1.toString()+".");
		System.out.printf("radius = %.2f\n", sph1.getradius());
		System.out.printf("surface area = %.3f\n", sph1.getArea());
		System.out.printf("volume = %.3f\n\n", sph1.getVolume());
		
		System.out.println(con1.toString()+".");
		System.out.printf("height = %.2f\n", con1.getheight());
		System.out.printf("radius = %.2f\n", con1.getradius());
		System.out.printf("surface area = %.3f\n", con1.getArea());
		System.out.printf("volume = %.3f\n", con1.getVolume());
		
	}
}
