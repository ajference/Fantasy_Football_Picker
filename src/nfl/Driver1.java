package nfl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Driver1 {

	public static void main(String[] args) {
	String destination = "";
	int g = 0;
	int back = 0;
	int weekchooser = 0;
	int firstTime = 0;
	Scanner scan = new Scanner (System.in);
	String[] Current = new String[8];
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
				System.out.println("Choose Which Match you Want to View or 9 to go back");
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
					System.out.println("Enter 1 to go back to weekly schedule or 2 to go back to main screen");
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
			String[] Temp = {"JO", "Momma", "is", "so", "nice"};
			String[] guru = new String[8];
			
			while(back == 1) {
				if(firstTime == 1) {
					System.out.println("Your Current team is " + Current[0] + " " + Current[1]);
					System.out.println("Do you want to select a new team? 1 for yes of 2 to go back to main screen");
					weekchooser = scan.nextInt();
					if(weekchooser == 1) {
						firstTime = 0;
					}
					if(weekchooser == 2) {
						g = 0; 
						back = 0;
						destination = scan.nextLine();
					}
					
				}
				if(firstTime == 0) {
					System.out.println("Welcome to Pick Guru\nTime To Make a Team!\nLet's Start with The QuarterBack\nChoose 1 of the top 5 quarterbacks\n1 JO\n2 Momma\n3 is\n4 so\n5 nice\n");
					weekchooser = scan.nextInt();
					guru[0] = Temp[weekchooser -1];
					System.out.println("Now time to Pick a Running Back Pick, Choose 1 of these 5 Runnings backs\n1 JO\n2 Momma\n3 is\n4 so\n5 nice\n ");
					weekchooser = scan.nextInt();
					guru[1] = Temp[weekchooser -1];
					System.out.println("The team you selected is " + guru[0] + " " + guru[1]);
					firstTime = 1;
					Current = guru;
					
					System.out.println("Enter 1 to go back to main screen");
					weekchooser = scan.nextInt();
					if(weekchooser == 1) {
						g = 0; 
						back = 0;
						destination = scan.nextLine();
					}
					}
				
			}
		}
		if(g == 3) {	//Team Maker
			System.out.println("Lets make a Team\n");
			System.out.println("Enter 1 to go back to main screen");
			weekchooser = scan.nextInt();
			if(weekchooser == 1) {
				g = 0; 
				back = 0;
				destination = scan.nextLine();
			}
			
		}
		if(g == 4) {	//Top Players
			System.out.println("These are this weeks top players!");
			System.out.println("Enter 1 to go back to main screen");
			weekchooser = scan.nextInt();
			if(weekchooser == 1) {
				g = 0; 
				back = 0;
				destination = scan.nextLine();
			}
			
		}
		
		}
}
	
	
}

