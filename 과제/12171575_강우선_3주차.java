package homework3;
public class complex {
	
private int realpart;
private int imaginarypart;
	
	public complex() 	{
		realpart = 0;
		imaginarypart = 0;
	}
	
	public complex(int real, int imaginary) {
		realpart = real;
		imaginarypart = imaginary;
	}
	
	public void setrealpart(int real) {
		realpart = real;
	}
	
	public int getrealpart() {
		return realpart;
	}
	
	public void setimaginarypart(int imaginary) {
		imaginarypart = imaginary;
	}
	
	public int getimaginarypart() {
		return imaginarypart;
	}

	public void print() {
		
        if (imaginarypart == 1){System.out.format("number is: %d+i\n",this.getrealpart());}
		
		else if(imaginarypart == -1) {
			System.out.format("number is: %d-i\n", this.getrealpart());
		} else if(imaginarypart == 0) {
			System.out.format("number is: %d\n", this.getrealpart());
		} else {
			System.out.format("number is: %d%+di\n", this.getrealpart(), this.getimaginarypart());
		}
	}
	
	public void complexadd(complex second) {
		if(imaginarypart+second.getimaginarypart() == 1) {
			System.out.printf ("Result of addition is: %d+i\n", realpart+second.getrealpart());
		} else if(imaginarypart+second.getimaginarypart() == -1) {
			System.out.printf ("Result of addition is: %d-i\n", realpart+second.getrealpart());
		} else if(imaginarypart+second.getimaginarypart() == 0) {
			System.out.printf ("Result of addition is: %d\n", realpart+second.getrealpart());
		} else {
			System.out.printf ("Result of addition is: %d%+di\n", realpart+second.getrealpart(), imaginarypart+second.getimaginarypart());
		}
		
	}
	
	public void complexsub(complex second) {
		if(imaginarypart-second.getimaginarypart() == 1) {
			System.out.printf ("Result of subtraction is: %d+i\n", 
				realpart-second.getrealpart());
		} else if (imaginarypart-second.getimaginarypart()== -1) {
			System.out.printf ("Result of subtraction is: %d-i\n", 
					realpart-second.getrealpart());
		} else if (imaginarypart-second.getimaginarypart()== 0) {
			System.out.printf ("Result of subtraction is: %d\n", 
					realpart-second.getrealpart());
		} else {
			System.out.printf ("Result of subtraction is: %d%+di\n", 
					realpart-second.getrealpart(), imaginarypart-second.getimaginarypart());
		}
		
	}
	
	public void complexmul(complex second) {
		if(realpart*second.getimaginarypart()+imaginarypart*second.getrealpart() == 1)
			System.out.printf ("Result of multiplication is: %d+i\n", 
					realpart*second.getrealpart()-imaginarypart*second.getimaginarypart());
		
		else if(realpart*second.getimaginarypart()+imaginarypart*second.getrealpart() == -1)
			System.out.printf("Result of multiplication is: %d-i\n", 
					realpart*second.getrealpart()-imaginarypart*second.getimaginarypart());
		
		else if(realpart*second.getimaginarypart()+imaginarypart*second.getrealpart() == 0)
			System.out.printf ("Result of multiplication is: %d\n", 
					realpart*second.getrealpart()-imaginarypart*second.getimaginarypart());
		
		else
		System.out.printf ("Result of multiplication is: %d%+di\n", 
				realpart*second.getrealpart()-imaginarypart*second.getimaginarypart(),
				realpart*second.getimaginarypart()+imaginarypart*second.getrealpart() );
		
	}
	
	public double calculate_absolval(complex second) {
		return Math.sqrt(this.realpart*this.realpart + this.imaginarypart* this.imaginarypart);
	}
	
	
	public static void main(String[] args) {
		
		complex first = new complex(1, 2);
		complex second = new complex(3, 0);
		
		System.out.print("First ");
		first.print();
		System.out.print("Second ");
		second.print();
		first.complexadd(second);
		first.complexsub(second);
		first.complexmul(second);
		
		return;
		
	}
	
}
