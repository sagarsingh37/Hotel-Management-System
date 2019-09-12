import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

class Room          //Room class for storing room information
{
	int rNumber;        // Room number
	int rCapacity;      // Room capacity
	void roomDetails(ArrayList<Room> roomObj)       // Room Details computation method
	{
		Scanner sc=new Scanner(System.in);
		int flag=0;
		int rNum;
		System.out.println("Please enter room number:");
		do
		{
			flag=0;
			rNum=sc.nextInt();
			for(Room obj:roomObj)	// check for room dublicacy
			{
				if(obj.rNumber==rNum)
				{
					System.out.println("Room already exists. Please enter room number:");
					flag=1;
					break;
				}
			}
		}while(flag==1);
		rNumber=rNum;	// room assigned
		if(flag==0)	
		{
			System.out.println("Please enter room capacity:");
			rCapacity=sc.nextInt();		// Capacity assigned
		}
	}
}
