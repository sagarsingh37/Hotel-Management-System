import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
class Guest     //Guest class for storing guest information
{
	String gName;
	void guestName(int id)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter guest name:");
		gName=sc.nextLine();
		System.out.println("Guest "+gName+" has been created with guest ID: "+(id+1));
	}
}
