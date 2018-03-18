
package homework2;
import java.util.Scanner;
public class seat_reservation {
	
	private int seat[][];
	
	seat_reservation() {
		seat = new int[6][6];
		for(int i =0;i<6; i++)
			for(int j=0; j<6; j++)
				if(Math.random()<0.5)
					seat[i][j] = 1;
	}
	
	public static void main(String[] args) {
		int choice;
		
		seat_reservation Sr = new seat_reservation();
		while((choice = Sr.menu()) != 4) {
			switch(choice) {
			case 1:
				Sr.show_map();
				break;
			case 2:
				Sr.find_availabe_seat();
				break;
			case 3:
				Sr.make_reserve();
				break;
			default:
				System.out.println("Plz input one of 1,2,3,4");
				break;
					
			}
	
		}
		System.out.print("Program Exited.");
		
	}
	public void show_map() {
		int count = 0;
		System.out.println("List of seats:");
		System.out.println("	1	2	3	4	5	6");
		System.out.println("-------------------------------------------------");
		for(int i =0;i<6;i++)
		{	
			System.out.print("   "+(i+1)+"|");
			for(int j=0; j<6;j++)
				{
					if(seat[i][j] ==0) 
					{
						System.out.print("	-");
						count++;
					}
					else if(seat[i][j] == 1)
						System.out.print("	+");
					else if(seat[i][j] == 2)
						System.out.print("	*");
				}
			System.out.print("\n");
		}
		System.out.println("Number of available seats : "+count);
	}
	
	public void find_availabe_seat() {
		for(int i =0; i<6;i++)
			for(int j =0; j<6; j++)
				if(seat[i][j] == 0)
					System.out.printf("(%d,%d)", i+1,j+1);
		System.out.println("");
		return;
	}
	
	public void make_reserve() {
		Scanner Sc = new Scanner(System.in);
		int input_row;
		int input_column;
		System.out.print("Input seat row: ");
		input_row = Sc.nextInt();
		System.out.print("Input seat column: ");
		input_column = Sc.nextInt();
		
		if(seat[input_row-1][input_column-1] == 0)
			{
				seat[input_row-1][input_column-1] = 2;
				System.out.println("Booked successfully.\n");
			}
		else
			System.out.println("The seat is not available.");
		
		
	}
	
	public int menu() {
		
		Scanner Sc = new Scanner(System.in);
		int input;
		System.out.println("\n=========================================");
		System.out.println("Enter number to choose the function:");
		System.out.println("1. Show the map");
		System.out.println("2. Find all available seat");
		System.out.println("3. Make a reserve");
		System.out.println("4. Exit");
		System.out.println("=========================================");
		System.out.print("Choice: ");
		input = Sc.nextInt();
		
		
		return input;
	}
}
