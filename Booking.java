import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

class Booking           //Booking class for making booking and storing(Guest, Room) information
{
	Scanner sc=new Scanner(System.in);
	int guestId;
	int roomNumber;
	int numOfGuest;
	int check_in=0,check_out=0;
	String gName;
	
	void addBooking(ArrayList<Guest> guestObj, ArrayList<Room> roomObj, ArrayList<Booking> bookingObj)      // Adding Booking method
	{
		int flag=0, flag_jump_guest_exceed=0;
		int id;
		int roomNum;
		do			// for guest check
		{
			flag=0;
			System.out.println("Please enter guest ID:");
			id=sc.nextInt();
			if(guestObj.size()>=id)		// means guest exists
			{
				int flag_room=0;		// flag check
				
				do		// For room check
				{
					flag_room=0;
					System.out.println("Please enter room number:");
					roomNum=sc.nextInt();
					for(Room room:roomObj)
					{
						if(room.rNumber==roomNum)	// check for the room existence
						{
							flag_room=0;
							flag_jump_guest_exceed=0;
							System.out.println("Please enter number of guests:");
							int numGuest=sc.nextInt();
							if(room.rCapacity>=numGuest)		// if Room capacity fulfilled
							{
								int check_in_mon,check_in_day;	// check-in month & day
								int check_out_mon,check_out_day;	// check-out month & day
								int flag_date_check=0;
				                do      // for Date validity check
				                {
    								do		// check-in MONTH
    								{
    									System.out.print("Please enter check-in month:");
    									check_in_mon=sc.nextInt();
    									if(check_in_mon>12 || check_in_mon<1)
    									{
    										System.out.println("Invalid month. ");
    									}						
    								}while(check_in_mon>12 || check_in_mon<1);
    								boolean check=false;
    								do		// check-in DAY
    								{
    									System.out.print("Please enter check-in day:");
    									check_in_day=sc.nextInt();
    									check=dayCheck(check_in_mon,check_in_day);	// function called to check day for month
    									if(!check)
    									{
    										System.out.println("Invalid day. ");
    									}		
    								}while(!check);	
    								//-----------------------
    								do		// check-out MONTH
    								{
    									System.out.print("Please enter check-out month:");
    									check_out_mon=sc.nextInt();
    									if(check_out_mon>12 || check_out_mon<1)
    									{
    									    System.out.println("Invalid month. ");
    									}
    								}while(check_out_mon>12 || check_out_mon<1);
    								boolean check1=false;
    								do		// check-out DAY
    								{
    									System.out.print("Please enter check-out day:");
    									check_out_day=sc.nextInt();
    									check1=dayCheck(check_out_mon,check_out_day);	// function called to check day for month
    									if(!check1)
    									{
    										System.out.println("Invalid day. ");
    									}			
    								}while(!check1);						
    								//------------------
    								int check_in_temp=dateToDayNumber(check_in_mon, check_in_day);
    								int check_out_temp=dateToDayNumber(check_out_mon, check_out_day);
    								flag_date_check=0;		// date check flag
    								for(Booking booking : bookingObj)	// checking database for same date existence
    								{
    									if(booking.roomNumber==roomNum)
    									{
    										if(booking.check_in==check_in_temp || booking.check_out==check_out_temp)
    										{
    											flag_date_check=1;
    											System.out.println("Room is not available during that period. ");
    											break;
    										}
    									}
    								}
    			
    								check_in=dateToDayNumber(check_in_mon, check_in_day);
    								check_out=dateToDayNumber(check_out_mon, check_out_day);
    								if(check_in>check_out)
    								{
    								    System.out.println("Invalid (check-in & check-out)");
    								}
				                }while(check_in>check_out);
				                if(flag_date_check==0) //all data below is now saved
    							{
    							//	check_in=dateToDayNumber(check_in_mon, check_in_day);
    							//	check_out=dateToDayNumber(check_out_mon, check_out_day);
    								numOfGuest=numGuest;
    								roomNumber=roomNum;
    								guestId=id;	
    								gName=guestObj.get(id-1).gName;
    								//System.out.println("\n\n "+check_in+"\n"+check_out+"\n"+gName+"\n\n");
								}
							}
							else
							{
								System.out.println("Guest count exceeds room capacity of "+room.rCapacity);
								flag_jump_guest_exceed=1;
							}
							break;
						}else
						{
							flag_room=1;
						}
					}
					if(flag_room==1)
					{
						System.out.println("Room does not exists. ");
					}
					
				}while(flag_room==1 || flag_jump_guest_exceed==1);
				// room exists now
				
			}else
			{
				System.out.println("Guest does not exists. ");
				flag=1;
			}
			
		}while(flag==1);
	}
	
	boolean dayCheck(int month, int day)        //Day checking Valid or Invalid
	{
		switch(month)
		{
		case 1: if(day<=31 && day>=1)
					return true;
		break;
		case 2: if(day<=28 && day>=1)
					return true;
		break;

		case 3: if(day<=31 && day>=1)
					return true;
		break;

		case 4: if(day<=30 && day>=1)
					return true;
		break;

		case 5: if(day<=31 && day>=1)
					return true;
		break;

		case 6: if(day<=30 && day>=1)
					return true;
		break;

		case 7: if(day<=31 && day>=1)
					return true;
		break;

		case 8: if(day<=31 && day>=1)
					return true;
		break;

		case 9: if(day<=30 && day>=1)
					return true;
		break;

		case 10: if(day<=31 && day>=1)
					return true;
		break;

		case 11: if(day<=30 && day>=1)
					return true;
		break;

		case 12: if(day<=31 && day>=1)
					return true;
		}
		return false;
	}
	int dateToDayNumber(int month,int day)	    //Date to Day Number convertion
	{
		switch(month)
		{
			case 1: return day;
			case 2: return 31+day;
			case 3: return 59+day;
			case 4: return 90+day;
			case 5: return 120+day;
			case 6: return 151+day;
			case 7: return 181+day;
			case 8: return 212+day;
			case 9: return 243+day;
			case 10: return 273+day;
			case 11: return 304+day;
 		}
		return 334+day;
	}
	void viewBookingRoom(Room room)     // View booking of ROOM
	{
		int CIM=dayNumberToMonth(check_in);			// check-in Month converted
		int CID=dayNumberToDayOfMonth(check_in);	// check-in Day converted
		int COM=dayNumberToMonth(check_out);		// check-out Month converted
		int COD=dayNumberToDayOfMonth(check_out);	// check-out Day converted
		System.out.println("Room "+roomNumber+" bookings,");
		System.out.println("Guest "+room.rCapacity+" - "+gName+", "+numOfGuest+" guest(s) from "+CIM+"/"+CID+" to "+COM+"/"+COD+".");
	}
	void viewBooking()          // View booking of Guest
	{
		int CIM=dayNumberToMonth(check_in);			// check-in Month converted
		int CID=dayNumberToDayOfMonth(check_in);	// check-in Day converted
		int COM=dayNumberToMonth(check_out);		// check-out Month converted
		int COD=dayNumberToDayOfMonth(check_out);	// check-out Day converted
		System.out.println("Guest "+guestId+" : "+gName);
		System.out.println("Booking : Room "+roomNumber+", "+numOfGuest+" guest(s) from "+CIM+"/"+CID+" to "+COM+"/"+COD+".");
	}
	int dayNumberToMonth(int day)           // Day number to Month conversion

	{
		if(day<=31)
			return 1;
		else if(day<=59)
			return 2;
		else if(day<=90)
			return 3;
		else if(day<=120)
			return 4;
		else if(day<=151)
			return 5;
		else if(day<=181)
			return 6;
		else if(day<=212)
			return 7;
		else if(day<=243)
			return 8;
		else if(day<=273)
			return 9;
		else if(day<=304)
			return 10;
		else if(day<=334)
			return 11;
		else 
			return 12;
	}
	int dayNumberToDayOfMonth(int day)          // Day number to Day of month conversion
	{
		if(day<=31)
			return day;
		else if(day<=59)
			return day-31;
		else if(day<=90)
			return day-59;
		else if(day<=120)
			return day-90;
		else if(day<=151)
			return day-120;
		else if(day<=181)
			return day-151;
		else if(day<=212)
			return day-181;
		else if(day<=243)
			return day-212;
		else if(day<=273)
			return day-243;
		else if(day<=304)
			return day-273;
		else if(day<=334)
			return day-304;
		else 
			return day-334;
	}
}
