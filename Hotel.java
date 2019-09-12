import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	public static Scanner sc=new Scanner(System.in);	// InputStream class for input	
	
	
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------");
		System.out.println("--------Welcome to Hotel SGR Booking--------");
		System.out.println("-----------------------------------------------");
		
		ArrayList<Guest> guestObj=new ArrayList<Guest>();	// Guest memory
		ArrayList<Room> roomObj=new ArrayList<Room>();	// Room memory
		ArrayList<Booking> bookingObj=new ArrayList<Booking>();	// Booking memory
		char ch = 0;		// used in some cases
		do
		{
			
			System.out.println("Main Menu - please select an option:");
			System.out.println("1.) Add guest");
			System.out.println("2.) Add room");
			System.out.println("3.) Add booking");
			System.out.println("4.) View bookings");
			System.out.println("5.) Quit");
			int choice=sc.nextInt();	// to switch between cases
			switch(choice)
			{
				case 1:	// Add guest
						do		
						{
							Guest obj=new Guest();	
							obj.guestName(guestObj.size());
							guestObj.add(obj);	//added to dynamic Guest arrayObject
							System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
							ch=sc.next().charAt(0);
						}while(ch=='A');
						break;
				
				case 2: // Add room
						do		
						{
							Room obj=new Room();
							obj.roomDetails(roomObj);
							roomObj.add(obj);		// added to dynamic Room arrayObject
							System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
							ch=sc.next().charAt(0);
						}while(ch=='A');
						break;
				
				case 3: // Add booking
						do
						{
							Booking obj=new Booking();
							obj.addBooking(guestObj, roomObj, bookingObj);
							bookingObj.add(obj);		// added to dynamic Booking arrayObject
							System.out.println("\n*** Booking successful ! ***\n");
							System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");
							ch=sc.next().charAt(0);
						}while(ch=='A');
						break;
				
				case 4: // View bookings
						do
						{
							System.out.println("Would you like to view [G]uest bookings, [R]oom booking or e[X]it?");
							ch=sc.next().charAt(0);
							if(ch=='X')
							{
								break;
							}else if(ch=='G')
							{
								int flag=0; 		// check condition for do_while
								do{
									flag=0;
									System.out.print("Please enter guest ID:");
									int id=sc.nextInt();
									if(id>guestObj.size())
									{
										flag=1;
										System.out.println("Guest does not exist. ");
									}else
									{
										for(Booking booking: bookingObj)
										{
											if(booking.guestId==id)
											{
												booking.viewBooking();
												break;
											}
										}
									}
								}while(flag==1);
							}else if(ch=='R')
							{
								int flag=0;
								do
								{
									flag=0;
									System.out.print("Please enter room number:");
									int roomNum=sc.nextInt();
									for(Room room: roomObj)
									{
										if(room.rNumber==roomNum)
										{
											flag=0;
											for(Booking booking: bookingObj)
											{
												if(booking.roomNumber==roomNum)
												{
													booking.viewBookingRoom(room);
												}
											}
											break;
										}
										else
										{
											System.out.println("Room does not exist. ");
											flag=1;
										}
									}
								}while(flag==1);
							}
						}while(ch=='G' || ch=='R');
						
						break;
				
				case 5:	// Quit
						System.out.println("Thanks for using Hotel SGR Bookings !");
						ch='A';	// 
			}
			System.out.println("");
		}while(ch!='A');
	}

}