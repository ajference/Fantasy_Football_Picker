package nfl;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Driver1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		NFL temp = new NFL();
		temp.buildNFL();
		
	
		
	String destination = "";
	int g = 0;
	int back = 0;
	int weekchooser = 0;
	int firstTime = 0;
	int firstTimet = 0;
	int week = 0;
	int match = 0;
	int teamguru = 0;
	int posRev = 0;
	int teamComp = 0;
	Scanner scan = new Scanner (System.in);
	ArrayList<Player> Current = new ArrayList<Player>();
	ArrayList<Player> myTeam = new ArrayList<Player>();
	while(back == 0) {
		back = 1;
		week = 0;
		match = 0;
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
				
//				System.out.println("These Are the teams that are playing this week");
//				System.out.println("1 Eagles vs Seahawks \n2 Dolphins vs Patriots\n3 Mo vs Bamba\n4 Justin vs Josh");
//				//NFL.printWeeklySchedule();
				System.out.println("Enter a week you want to view (1-17) or Enter 25 to go back");
				weekchooser = scan.nextInt();
				week = weekchooser;
				if(weekchooser == 25) {
					g = 0; 
					back = 0;
					destination = scan.nextLine();
				}
				else if(weekchooser > 17) {
					System.out.println("Enter A valid Week");
				}
				else {
				temp.printWeeklySchedule(weekchooser);
				back = 2;
				while (back == 2) {

					System.out.println("Enter a Match you want to view or enter 35 to go choose a different week or 40 to go back to main screen");
					weekchooser =  scan.nextInt();
					if (weekchooser != (int)weekchooser) {
						weekchooser  = 100;
					}
					
					if(weekchooser == 40) {
						g = 0; 
						back = 0;
						destination = scan.nextLine();
					}
					else if(weekchooser == 35) {
						back = 1;
						destination = scan.nextLine();
					}
					else if(weekchooser >= 1 && weekchooser <= 17) {
					
					match = weekchooser;
					NFL.teamComparison(week, match);
					}
					else {
						System.out.println("Enter a Valid Command");
					}
				}
				}
				}
			}
		
		if(g == 2) {	//PickGUru
			//String[] Temp = {"JO", "Momma", "is", "so", "nice"};
			ArrayList<Player> guru = new ArrayList<Player>();
			
			while(back == 1) {
				if(firstTime == 1) {

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
					System.out.println("Welcome to Pick Guru\nTime To Make a Team!\nLet's Start with The QuarterBack\nChoose 1 of the top 5 quarterbacks");
					NFL.printPlayerPosition(0, 4, 5);
					weekchooser = scan.nextInt();
					guru.add(NFL.getPlayer(weekchooser - 1));
					System.out.println("Now time to Pick a Running Back Pick, Choose 1 of these 5 Runnings backs");
					NFL.printPlayerPosition(0, 3, 5);
					weekchooser = scan.nextInt();
					guru.add(NFL.getPlayer(weekchooser - 1));
					System.out.println("The team you selected is " + guru.get(0).getName() + " " + guru.get(1).getName());
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
			while(back == 1) {
				if(firstTime == 1 && teamComp == 0) {
					System.out.println("It looks like you have already used Pick Guru, do you want to use the Same team? 1 for yes, 2 for no");
					weekchooser = scan.nextInt();
					if(weekchooser == 1) {
						myTeam = Current;
						teamComp = 1;
					}
					else if(weekchooser == 2) {
						teamguru = 1;
					}
					else {
						System.out.println("Enter a Valid Choice");
					}
				}
				
				if(teamguru == 1 && firstTimet == 0)
				System.out.println("Lets make a Team\n");
				firstTimet = 1;
				if(posRev == 1  || teamComp == 0) {
					System.out.println("Selecting a QB\n Pick A QB from the List of All available QBs");
				//Print out QB List
				
				//myTeam[0] = "What Ever QB they Pick";
				}
				//Repeat for all other possitions
				
				System.out.println("Your Team is now Complete, Enter 1 to go back to main screen or Select a possition to change 1 for QB 2 for Rb 3 for WR ...");
				teamComp = 1;
				weekchooser = scan.nextInt();
				if(weekchooser == 1) {
					g = 0; 
					back = 0;
					destination = scan.nextLine();
				}
			}
			
		}
		if(g == 4) {	//Top Players
			System.out.println("These are this weeks top players!");
			NFL.printTeamPlayers(7,0);
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
	
//	public boolean stringCheck() {
//	Scanner testscan = new Scanner(System.in);
//	int test; 
//	    try
//	    {
//	        test = testscan.nextInt();
//	        return false;
//	    } catch (InputMismatchException ex)
//	    {
//	        return true;
//	    }
//	}
	
	
	
	
}
	
	


