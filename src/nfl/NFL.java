package nfl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NFL {
	Map <String,String> schedule;
	List<Integer> numGames;
	public NFL() {
		schedule = new HashMap<String,String>();
		numGames = new ArrayList<Integer>();
	}
	public void buildNFL (String[]args) throws FileNotFoundException {
		int count = 1; 
		String Week = null;
		Scanner in = new Scanner(new File(args[0]));
		while (in.hasNextLine()){
			String line = in.nextLine();
			String[] feilds = line.split(",");
			String x = feilds[0].split(" ")[0];
			if (x.compareTo("Week") == 0) {
				if (Week != null) {
				numGames.add(count - 1);
				}
				Week = feilds[0];
				count = 1;
		    }
			for (int j = 0; j < feilds.length - 1; j++) {
				if (feilds[j].charAt(0) != '"' && feilds[j].compareTo(Week) != 0) {
			schedule.put(Week + "G" + count, feilds[j]);
			count ++;
				}
			}
		}
		numGames.add(count - 1);
	}
	
	public void printWeeklySchedule(int week) {
		System.out.println("Week "+ week + " Games:");
		for (int j = 0; j < numGames.get(week - 1); ++j) {
		String x = schedule.get("Week "+ week + ":G" + (j+1));
		System.out.println((j + 1) +" " + x.split("@ ")[0] + "Vs." + x.split("@ ")[1]);
		}
		
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		NFL temp = new NFL();
//		temp.buildNFL(args);
//		temp.printWeeklySchedule(17);
//
//	}
	
	
	public static void addTeam(Team team) {
		// TODO Auto-generated method stub
		//FIXME
	}
	
	public static void teamComparison(Team team1, Team team2) {
		System.out.println("Comparing The " + team1.getName() + " vs. The " + team2.getName());
		
		// Offset numbers are from 2 to 64
		// low valued numbers show a bad team/position going against a good team/position defense
		// high valued numbers show a good team/position going against a bad team/position defense
		
		
		int team1_Offensive_Offset = 33-team1.getOffensiveRank()+team2.getDefensiveRank();
		int team2_Offensive_Offset = 33-team2.getOffensiveRank()+team1.getDefensiveRank();
		
		int team1_QB_Offset = 33-team1.getqbOfRank()+team2.getqbDeRank();
		int team2_QB_Offset = 33-team2.getqbOfRank()+team1.getqbDeRank();
		
		int team1_RB_Offset = 33-team1.getrbOfRank()+team2.getrbDeRank();
		int team2_RB_Offset = 33-team2.getrbOfRank()+team1.getrbDeRank();
		
		int team1_WR_Offset = 33-team1.getwrOfRank()+team2.getwrDeRank();
		int team2_WR_Offset = 33-team2.getwrOfRank()+team1.getwrDeRank();
		
		int team1_TE_Offset = 33-team1.getteOfRank()+team2.getteDeRank();
		int team2_TE_Offset = 33-team2.getteOfRank()+team1.getteDeRank();
		
		
		
		// Take a look at the offset for team 1's overall offense
		System.out.println("Deeper look into The " + team1.getName() + ":");
		
		System.out.println("The " + team1.getName() + " have an overall offensive rank of " + team1.getOffensiveRank() + " and are up against The " + team2.getName() + " who have a defensive rank of " + team1.getOffensiveRank() + ".");
		//Terrible
		if(team1_Offensive_Offset >= 2 && team1_Offensive_Offset <= 16) {
			System.out.println("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName());
			System.out.println("Fantasy players on The " + team1.getName() + " are expected to score lower than normal");
		}
		//Bad
		else if(team1_Offensive_Offset >= 17 && team1_Offensive_Offset <= 30) {
			System.out.println("With this matchup it is discouarged to pick players from The" + team1.getName());
			System.out.println("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal");
		}
		//Average
		else if(team1_Offensive_Offset >= 31 && team1_Offensive_Offset <= 36) {
			System.out.println("This matchup is close for both teams");
			System.out.println("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game");
		}
		//Good
		else if(team1_Offensive_Offset >= 37 && team1_Offensive_Offset <= 49) {
			
		}
		//Exceptional
		else {
			System.out.println("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName());
		}
		
		
	}
	
	
}
