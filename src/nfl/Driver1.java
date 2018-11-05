package nfl;
import java.util.Collections;
import java.util.Scanner;



public class Driver1 {

	public static void main(String[] args) {
	String destination = "";
	int g = 0;
	int back = 0;
	int weekchooser = 0;
	Scanner scan = new Scanner (System.in);
	while(back == 0) {
		back = 1;
		while(g == 0) {
			System.out.println("Type out Destination : Weekly -- Pick Guru -- My Team -- Top Players");
			destination = scan.nextLine().toLowerCase();
		
			switch(destination) {
				case "weekly" :
					g = 1;
					break;
				case "pick guru":
					g = 2;
					break;
				case "my team": 
					g = 3;
					break;
				case "top players":
					g = 4;
					break;
				
				default:
					System.out.println("Enter a proper Destination");
					
				}
				
			}
		if(g == 1) {	//Weekly
			while(back == 1) {
				System.out.println("These Are the teams that are playing this week");
				System.out.println("1 Eagles vs Seahawks \n2 Dolphins vs Patriots\n3 Mo vs Bamba\n4 Justin vs Josh");
				//NFL.printWeeklySchedule();
				System.out.println("Choose Which Match you Want to View or hit 9 to go back");
				weekchooser = scan.nextInt();
				if(weekchooser == 9) {
					g = 0; 
					back = 0;
					destination = scan.nextLine();
				}
				
				if(weekchooser == 2) {
					System.out.println("Team 1 Vs Team 2");
					System.out.println("Team's 1 Ranks is 3 Team 2's Rank is 1 ");
					System.out.println("The Team favored to win is team 2 ");
					System.out.println("Key Playres to look out for \nMarek Perez \nAJ Ference \nJoshua Silverio\n");
					System.out.println("Enter 1 to go back to weeklySchdule or 2 to go back to main screen");
					weekchooser = scan.nextInt();
					if(weekchooser == 2) {
						g = 0; 
						back = 0;
						destination = scan.nextLine();
					}
					if(weekchooser == 1) {
						back = 1;
						destination = scan.nextLine();
					}
				}
				
			}
		}
		if(g == 2) {	//PickGUru
			System.out.println("Welcom to Pick Guru\nTime To Make a Team!\nLet's Start with The QuarterBack ");
			
		}
		if(g == 3) {	//Team Maker
			System.out.println("Lets make a Team");
			
		}
		if(g == 4) {	//Top Players
			System.out.println("These are this weeks top players!");
			
		}
		
		}
}
	
	
}

