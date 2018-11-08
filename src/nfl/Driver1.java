package nfl;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import dataCollection.CalculateRanks;



public class Driver1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		NFL temp = new NFL();
		
	
		
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
	int wideRe = 0;
	int wideRe1 = 0;
	int wideRe2 = 0;
	int numChecker = 0;
	int guruCheck = 0;
	int wrRev = 0;
	Scanner scan = new Scanner (System.in);
	ArrayList<Player> Current = new ArrayList<Player>();
	ArrayList<Player> myTeam = new ArrayList<Player>();
	while(back == 0) {
		back = 1;
		week = 0;
		match = 0;
		while(g == 0) {
			System.out.println("Type out Destination : Weekly -- Pick Guru -- My Team -- Top Players");
			destination = scan.nextLine().toLowerCase().replaceAll( "\\s+", "");
			
			switch(destination) {
				case "weekly" :
					g = 1;
					break;
				case "pickguru":
					g = 2;
					break;
				case "myteam": 
					g = 3;
					break;
				case "topplayers":
					g = 4;
					break;
				
				default:
					System.out.println("Enter a proper Destination");
					
				}
				
			}
		if(g == 1) {	//Weekly
			while(back == 1) {
				

				System.out.println("Enter a week you want to view (1-17) or Enter 25 to go back");

				while(!scan.hasNextInt()) {
				System.out.println("Enter a Number");	
				scan.next();
				}
				weekchooser = scan.nextInt();
				
				week = weekchooser;
				if(weekchooser == 25) {
					g = 0; 
					back = 0;
					destination = scan.nextLine();
				}
				else if(weekchooser > 17 || weekchooser < 0) {
					System.out.println("Enter A valid Week");
				}
				else {
				temp.printWeeklySchedule(weekchooser);
				back = 2;
				while (back == 2) {

					System.out.println("Enter a Match you want to view or enter 35 to go choose a different week or 40 to go back to main screen");
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
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
					else if(weekchooser >= 1 && weekchooser <= temp.getFile().getNumGames().get(week - 1)) { 
					
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
			
			ArrayList<Player> guru = new ArrayList<Player>();
			guruCheck = 1;
			
			while(back == 1) {
				if(firstTime == 1) {

					System.out.println("Do you want to select a new team? 1 for yes of 2 to go back to main screen");
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
					weekchooser = scan.nextInt();
					if(weekchooser == 1) {
						firstTime = 0;
					}
					else if(weekchooser == 2) {
						g = 0; 
						back = 0;
						destination = scan.nextLine();
					}
					else {
						System.out.println("Enter a Valid Choice");
					}
				}
				if(firstTime == 0) {
					while(numChecker == 0) {
					System.out.println("Welcome to Pick Guru\nTime To Make a Team!\nLet's Start with The QuarterBack\nChoose 1 of the top 5 quarterbacks");
					NFL.printPlayerPosition(0, 4, 5);
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
					weekchooser = scan.nextInt();
					if(weekchooser > 5 || weekchooser < 0) {
						System.out.println("Enter a valid Choice");
					}
					else {
						numChecker = 1;
					}
					}
					guru.add(NFL.getPlayer(weekchooser - 1));
					numChecker = 0;
					while(numChecker == 0) {
					System.out.println("Now time to Pick a Running Back Pick, Choose 1 of these 5 Runnings backs");
					NFL.printPlayerPosition(0, 3, 5);
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
					weekchooser = scan.nextInt();
					
					if(weekchooser > 5 || weekchooser < 0) {
						System.out.println("Enter a valid Choice");
					}
					else {
						numChecker = 1;
					}
					
					}
					guru.add(NFL.getPlayer(weekchooser - 1));
					numChecker = 0;
					
					while(numChecker == 0) {
					System.out.println("Now time to Pick your first Wide Reciever, Choose 1 of these 7 Wide Recievers backs");
					NFL.printPlayerPosition(0, 2, 7);
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
					weekchooser = scan.nextInt();
					
					if(weekchooser > 7 || weekchooser < 0) {
						System.out.println("Enter a valid Choice");
					}
					else {
						numChecker = 1;
					}
					
					}
					numChecker = 0;
					wideRe = weekchooser;
					guru.add(NFL.getPlayer(weekchooser - 1));
					
					while(wideRe2 == 0) {
					System.out.println("Now time to Pick your Second Wide Reciever, Choose 1 of these 7 Wide Recievers backs");
					NFL.printPlayerPosition(0, 2, 7);
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
					weekchooser = scan.nextInt();
					wideRe1 = weekchooser;
					
					if(weekchooser != wideRe && weekchooser <= 7 && weekchooser > 0) {
					guru.add(NFL.getPlayer(weekchooser - 1));
					wideRe2 = 2;
					}
					else {
						if(weekchooser > 7 || weekchooser < 0) {
							System.out.println("Enter a valid Choice");
						}
						else {
						System.out.println("You have already picked that player, Pick a different one");
						}
					}
					
					}
					wideRe2 = 0;
					
					while(wideRe2 == 0) {
						System.out.println("Now time to Pick your Third Wide Reciever, Choose 1 of these 7 Wide Recievers backs");
						NFL.printPlayerPosition(0, 2, 7);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						
						if(weekchooser != wideRe && weekchooser != wideRe1 && weekchooser <= 7 && weekchooser > 0) {
						guru.add(NFL.getPlayer(weekchooser - 1));
						wideRe2 = 1;
						}
						else {
							if(weekchooser > 7 || weekchooser < 0) {
								System.out.println("Enter a valid Choice");
							}
							else {
							System.out.println("You have already picked that player, Pick a different one");
							}
						}
						
					}
					
					while(numChecker == 0) {
					System.out.println("Now time to Pick your Tight End, Choose 1 of these 5 Tight Ends");
					NFL.printPlayerPosition(0, 1, 5);
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
					weekchooser = scan.nextInt();
					if(weekchooser > 5 || weekchooser < 0) {
						System.out.println("Enter a valid Choice");
					}
					else {
						numChecker = 1;
					}
					
					}
					wideRe = weekchooser;
					guru.add(NFL.getPlayer(weekchooser - 1));
					
					numChecker = 0;
					
					
					System.out.println("\nThe team you selected is\nQuarterBack \t\t" + guru.get(0).getName() + "\nRunning Back \t\t" + guru.get(1).getName() + "\nWide Reciever 1 \t" + guru.get(2).getName() + "\nWide Reciever 2 \t" + guru.get(3).getName() + "\nWide Reciever 3 \t" + guru.get(4).getName() + "\nTight End \t\t" + guru.get(5).getName());
					firstTime = 1;
					Current = guru;
					
					System.out.println("Enter 1 to go back to main screen");
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
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
				if(guruCheck == 1 && teamComp == 0) {
					System.out.println("It looks like you have already used Pick Guru, do you want to use the Same team? 1 for yes, 2 for no");
					while(!scan.hasNextInt()) {
						System.out.println("Enter a Number");	
						scan.next();
						}
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
					while(numChecker == 0) {
						System.out.println("Selecting a QB\n Pick A QB from the 15 best QBs");
						NFL.printPlayerPosition(0, 4, 15);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						if(weekchooser < 0 && weekchooser > 15) {
							System.out.println("Enter a valid Choice");
						}
						else {
							numChecker = 1;
						}
					}
					if(posRev == 1) {
						myTeam.set(0, NFL.getPlayer(weekchooser - 1));
					}
					else {
						myTeam.add(NFL.getPlayer(weekchooser - 1));
					}
				numChecker = 0;
				}
				
				if(posRev == 2  || teamComp == 0) {
					while(numChecker == 0) {
						System.out.println("Selecting a RB\n Pick A RB from the 15 best QBs");
						NFL.printPlayerPosition(0, 3, 15);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						if(weekchooser < 0 && weekchooser > 15) {
							System.out.println("Enter a valid Choice");
						}
						else {
							numChecker = 1;
						}
					}
				if(posRev == 2) {
					
				}
				if(posRev == 2) {
					myTeam.set(1, NFL.getPlayer(weekchooser - 1));
				}
				else {
					myTeam.add(NFL.getPlayer(weekchooser - 1));
				}
				numChecker = 0;
				}
				
				
				if(posRev == 3 || teamComp == 0) {
					if(posRev == 3) {
						while(posRev == 3) {
							System.out.println("Which WR do you want to change? 1 2 or 3?");
							while(!scan.hasNextInt()) {
								System.out.println("Enter a Number");	
								scan.next();
								}
							weekchooser = scan.nextInt();
							if(weekchooser < 0 || weekchooser > 3) {
								System.out.println("Enter a valid Choice");
							}
							else {
								posRev = weekchooser;
								wrRev = 1;
							}
						}
					}
					
					while(wideRe2 == 0) {
						if((wrRev == 1 && (posRev == 2 || posRev == 3))) {
							break;
						}
						System.out.println("Pick your First WR");
						NFL.printPlayerPosition(0, 2, 15);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						
						if(weekchooser > 15 || weekchooser < 0) {
							System.out.println("Enter a valid Choice");
						}
						else {
							wideRe2 = 1;
						}
						
						}
						wideRe2 = 0;
						wideRe = weekchooser;
						if(posRev == 1) {
							myTeam.set(2, NFL.getPlayer(weekchooser - 1));
						}
						else {
							myTeam.add(NFL.getPlayer(weekchooser - 1));
						}
						
					while(wideRe2 == 0) {
						if((wrRev == 1 && (posRev == 1 || posRev == 3))) {
							break;
						}
						System.out.println("Pick the second WR");
						NFL.printPlayerPosition(0, 2, 15);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						wideRe1 = weekchooser;
						
						if(weekchooser < 15 && weekchooser > 0 && wideRe != weekchooser) {
							if(posRev == 2) {
								myTeam.set(3, NFL.getPlayer(weekchooser - 1));
							}
							else {
								myTeam.add(NFL.getPlayer(weekchooser -1 ));
							}
							wideRe2 = 1;
						}
						else {
							if(weekchooser  > 15 && weekchooser < 0) {
								System.out.println("Enter a Valid Choice");
							}
							else {
								System.out.println("You have Already Picked that WR");
							}
						}
					}
					wideRe2 = 0;
					
					while(wideRe2 == 0) {
						if((wrRev == 1 && (posRev == 1 || posRev == 2))) {
							break;
						}
						System.out.println("Pick the third WR");
						NFL.printPlayerPosition(0, 2, 15);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						
						if(weekchooser < 15 && weekchooser > 0 && wideRe != weekchooser && wideRe1 != weekchooser) {
							if(posRev == 3) {
								myTeam.set(4, NFL.getPlayer(weekchooser - 1));
							}
							else {
							myTeam.add(NFL.getPlayer(weekchooser -1 ));
							}
							wideRe2 = 1;
						}
						else {
							if(weekchooser  > 15 && weekchooser < 0) {
								System.out.println("Enter a Valid Choice");
							}
							else {
								System.out.println("You have Already Picked that WR");
							}
						}
					}
					wideRe2 = 0;
					
		
					
				}
				
				
				if(posRev == 4  || teamComp == 0) {
					while(numChecker == 0) {
						System.out.println("Selecting a TE\n Pick A TE from the 15 best TEs");
						NFL.printPlayerPosition(0, 1, 15);
						while(!scan.hasNextInt()) {
							System.out.println("Enter a Number");	
							scan.next();
							}
						weekchooser = scan.nextInt();
						if(weekchooser < 0 && weekchooser > 15) {
							System.out.println("Enter a valid Choice");
						}
						else {
							numChecker = 1;
						}
					}
					if(posRev == 4) {
						myTeam.set(5, NFL.getPlayer(weekchooser - 1));
					}
					else {
						myTeam.add(NFL.getPlayer(weekchooser - 1));
					}
				numChecker = 0;
				}
				
				
				
				System.out.println("Your Team is now Complete\nQuarterBack \t\t" + myTeam.get(0).getName() + "\nRunning Back \t\t" + myTeam.get(1).getName() + "\nWide Reciever 1 \t" + myTeam.get(2).getName() + "\nWide Reciever 2 \t" + myTeam.get(3).getName() 
						+ "\nWide Reciever 3 \t" + myTeam.get(4).getName() + "\nTight End \t\t" + myTeam.get(5).getName() + "\n"
						+"Enter 5 to go back to main screen or Select a position to change\n1 for QB \n2 for RB \n3 for WR \n4 for TE");
				teamComp = 1;
				while(!scan.hasNextInt()) {
					System.out.println("Enter a Number");	
					scan.next();
					}
				weekchooser = scan.nextInt();
				if(weekchooser == 5) {
					g = 0; 
					back = 0;
					destination = scan.nextLine();
					posRev = 0;
				}
				else if (weekchooser >= 1 && weekchooser <= 4) {
					posRev = weekchooser;
				}
				else {
					System.out.println("Enter a Valid Choice");
				}
			}
			
		}
		if(g == 4) {	//Top Players
			posRev = 0;
			numChecker = 0;
			while(posRev == 0) {
				while(numChecker == 0) {
				System.out.println("Enter a week 1-17");
				while(!scan.hasNextInt()) {
					System.out.println("Enter a Number");	
					scan.next();
					}
				weekchooser = scan.nextInt();
				
				if(weekchooser < 17 && weekchooser > 0) {
					numChecker = 1;
				}
				else {
					System.out.println("Enter a valid Choice");
				}
				
				
				}
				System.out.println("These are this weeks top players!");
				CalculateRanks.makeBreakDown(weekchooser);
			
				
				System.out.println("Enter 1 to go back to main screen or 2 to choose a new week");
				while(!scan.hasNextInt()) {
					System.out.println("Enter a Number");	
					scan.next();
					}
				weekchooser = scan.nextInt();
				
				if(weekchooser == 1) {
					g = 0; 
					back = 0;
					destination = scan.nextLine();
					posRev = 1;
				}
				else if(weekchooser == 2) {
					posRev = 0;
					numChecker = 0;
					destination = scan.nextLine();
				}
				else {
					System.out.println("Enter a valid Choice");
				}
			}
		}
	}
		}
	

	
	
	
	
}
	
	


