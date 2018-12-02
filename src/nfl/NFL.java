package nfl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import dataCollection.ReadFiles;
import javafx.beans.property.SimpleStringProperty;

public class NFL {
	private static ArrayList <Player> playerList;
	protected static Map <String,Team> teams;
	private static Map <String,ArrayList<Player>> players;
	private static Map <Integer, String> teamNames;
	private static Map <String,ArrayList<Player>> playerPositions;
	private static Map <String, HashMap<String, ArrayList<Player>>> teamPositions;
	protected static ReadFiles files;
	SimpleStringProperty weeks;
	public NFL() throws FileNotFoundException {
		files = new ReadFiles();
		playerPositions = new HashMap <String,ArrayList<Player>>();
		teamPositions = new HashMap <String, HashMap<String, ArrayList<Player>>>();
		teams = new HashMap<String,Team>();
		playerList = new ArrayList<Player>();
	}
	
	public ArrayList<String> printWeeklySchedule(int week) {
		ArrayList<String> matches = new ArrayList<String>();
		Map <String,String> schedule = files.getSchedule();
		List<Integer> numGames = files.getNumGames();
		//System.out.println("Week "+ week + " Games:", 0);
		for (int j = 0; j < numGames.get(week - 1); ++j) {
		String x = schedule.get("Week "+ week + ":G" + (j+1));
		matches.add((x.split("@ ")[0] + "Vs." + x.split("@ ")[1]));;
		}
		return  matches;
	}
	
	public ReadFiles getFile(){
		return files;
	}
	
	
	
public static String teamComparison(int week, int match){
		String printerString = "";
		
		teams = files.getTeamInfoMap();
		Map <String,String> schedule = files.getSchedule();
		String x = schedule.get("Week "+ week + ":G" + match);
		String w = x.split(" @ ")[0];
		String f = x.split(" @ ")[1].substring(1, x.split(" @ ")[1].length());
		w = NFL.checkString(w, teams);
		//f = NFL.checkString(f, teams);
		Team team1 = teams.get(w);
		Team team2 = teams.get(f);
		printerString += ("Comparing The " + team1.getName() + " vs. The " + team2.getName() + "\n");
		
		
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
		
		
		
		// Take a look at the offset for team 1
		printerString += ("Deeper look into The " + team1.getName() + ":" + "\n");
		
		
	// Team1 overall offset
		printerString += ("The " + team1.getName() + " have an overall offensive rank of " + team1.getOffensiveRank() + " and are up against The " + team2.getName() + " who have a defensive rank of " + team2.getDefensiveRank() + "." + "\n");
		//Terrible
		if(team1_Offensive_Offset >= 2 && team1_Offensive_Offset <= 16) {
			printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal" + "\n");
		}
		//Bad
		else if(team1_Offensive_Offset >= 17 && team1_Offensive_Offset <= 30) {
			printerString += ("With this matchup it is discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal" + "\n");
		}
		//Average
		else if(team1_Offensive_Offset >= 31 && team1_Offensive_Offset <= 36) {
			printerString += ("This matchup is close for both teams" + "\n" + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game" + "\n");
		}
		//Good
		else if(team1_Offensive_Offset >= 37 && team1_Offensive_Offset <= 49) {
			printerString += ("With this matchup it is encouraged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score higher than normal" + "\n");
		}
		//Exceptional
		else {
			printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal" + "\n");
		}
		
	// Team1 QB offset
		printerString += ("The " + team1.getName() + " have an overall qb rank of " + team1.getqbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getqbDeRank() + "." + "\n");
		//Terrible
		if(team1_QB_Offset >= 2 && team1_QB_Offset <= 16) {
			printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal" + "\n");
		}
		//Bad
		else if(team1_QB_Offset >= 17 && team1_QB_Offset <= 30) {
			printerString += ("With this matchup it is discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal" + "\n");
		}
		//Average
		else if(team1_QB_Offset >= 31 && team1_QB_Offset <= 36) {
			printerString += ("This matchup is close for both teams" + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game" + "\n");
		}
		//Good
		else if(team1_QB_Offset >= 37 && team1_QB_Offset <= 49) {
			printerString += ("With this matchup it is encouraged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score higher than normal" + "\n");
		}
		//Exceptional
		else {
			printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal" + "\n");
		}
		
	// Team1 RB offset
		printerString += ("The " + team1.getName() + " have an overall rb rank of " + team1.getrbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getrbDeRank() + "." + "\n");
		//Terrible
		if(team1_RB_Offset >= 2 && team1_RB_Offset <= 16) {
			printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal" + "\n");
		}
		//Bad
		else if(team1_RB_Offset >= 17 && team1_RB_Offset <= 30) {
			printerString += ("With this matchup it is discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal" + "\n");
		}
		//Average
		else if(team1_RB_Offset >= 31 && team1_RB_Offset <= 36) {
			printerString += ("This matchup is close for both teams" + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game" + "\n");
		}
		//Good
		else if(team1_RB_Offset >= 37 && team1_RB_Offset <= 49) {
			printerString += ("With this matchup it is encouraged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score higher than normal" + "\n");
		}
		//Exceptional
		else {
			printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal" + "\n");
		}
		
	// Team1 WR offset
		printerString += ("The " + team1.getName() + " have an overall wr rank of " + team1.getwrOfRank() + " and are up against The " + team2.getName() + " who have a wr defensive rank of " + team2.getwrDeRank() + "." + "\n");
		//Terrible
		if(team1_WR_Offset >= 2 && team1_WR_Offset <= 16) {
			printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal" + "\n");
		}
		//Bad
		else if(team1_WR_Offset >= 17 && team1_WR_Offset <= 30) {
			printerString += ("With this matchup it is discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal" + "\n");
		}
		//Average
		else if(team1_WR_Offset >= 31 && team1_WR_Offset <= 36) {
			printerString += ("This matchup is close for both teams" + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game" + "\n");
		}
		//Good
		else if(team1_WR_Offset >= 37 && team1_WR_Offset <= 49) {
			printerString += ("With this matchup it is encouraged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score higher than normal" + "\n");
		}
		//Exceptional
		else {
			printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal" + "\n");
		}
		
	// Team1 TE offset
		printerString += ("The " + team1.getName() + " have an overall te rank of " + team1.getteOfRank() + " and are up against The " + team2.getName() + " who have a te defensive rank of " + team2.getteDeRank() + "." + "\n");
		//Terrible
		if(team1_WR_Offset >= 2 && team1_WR_Offset <= 16) {
			printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal" + "\n");
		}
		//Bad
		else if(team1_WR_Offset >= 17 && team1_WR_Offset <= 30) {
			printerString += ("With this matchup it is discouarged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal" + "\n");
		}
		//Average
		else if(team1_WR_Offset >= 31 && team1_WR_Offset <= 36) {
			printerString += ("This matchup is close for both teams" + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game" + "\n");
		}
		//Good
		else if(team1_WR_Offset >= 37 && team1_WR_Offset <= 49) {
			printerString += ("With this matchup it is encouraged to pick players from The" + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score higher than normal" + "\n");
		}
		//Exceptional
		else {
			printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			printerString += ("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal" + "\n");
		}
	
		
		// Take a look at the offset for team 2
		printerString += ("Deeper look into The " + team2.getName() + ":" + "\n");
		
		// Team2 overall offset
				printerString += ("The " + team2.getName() + " have an overall offensive rank of " + team2.getOffensiveRank() + " and are up against The " + team1.getName() + " who have a defensive rank of " + team1.getDefensiveRank() + "." + "\n");
				//Terrible
				if(team2_Offensive_Offset >= 2 && team2_Offensive_Offset <= 16) {
					printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal" + "\n");
				}
				//Bad
				else if(team2_Offensive_Offset >= 17 && team2_Offensive_Offset <= 30) {
					printerString += ("With this matchup it is discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal" + "\n");
				}
				//Average
				else if(team2_Offensive_Offset >= 31 && team2_Offensive_Offset <= 36) {
					printerString += ("This matchup is close for both teams" + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game" + "\n");
				}
				//Good
				else if(team2_Offensive_Offset >= 37 && team2_Offensive_Offset <= 49) {
					printerString += ("With this matchup it is encouraged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score higher than normal" + "\n");
				}
				//Exceptional
				else {
					printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal" + "\n");
				}
				
				// Team2 QB offset
				printerString += ("The " + team2.getName() + " have an overall qb rank of " + team2.getqbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getqbDeRank() + "." + "\n");
				//Terrible
				if(team2_QB_Offset >= 2 && team2_QB_Offset <= 16) {
					printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal" + "\n");
				}
				//Bad
				else if(team2_QB_Offset >= 17 && team2_QB_Offset <= 30) {
					printerString += ("With this matchup it is discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal" + "\n");
				}
				//Average
				else if(team2_QB_Offset >= 31 && team2_QB_Offset <= 36) {
					printerString += ("This matchup is close for both teams" + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game" + "\n");
				}
				//Good
				else if(team2_QB_Offset >= 37 && team2_QB_Offset <= 49) {
					printerString += ("With this matchup it is encouraged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score higher than normal" + "\n");
				}
				//Exceptional
				else {
					printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal" + "\n");
				}
				
			// Team2 RB offset
				printerString += ("The " + team2.getName() + " have an overall rb rank of " + team2.getrbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getrbDeRank() + "." + "\n");
				//Terrible
				if(team2_RB_Offset >= 2 && team2_RB_Offset <= 16) {
					printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal" + "\n");
				}
				//Bad
				else if(team2_RB_Offset >= 17 && team2_RB_Offset <= 30) {
					printerString += ("With this matchup it is discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal" + "\n");
				}
				//Average
				else if(team2_RB_Offset >= 31 && team2_RB_Offset <= 36) {
					printerString += ("This matchup is close for both teams" + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game" + "\n");
				}
				//Good
				else if(team2_RB_Offset >= 37 && team2_RB_Offset <= 49) {
					printerString += ("With this matchup it is encouraged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score higher than normal" + "\n");
				}
				//Exceptional
				else {
					printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal" + "\n");
				}
				
			// Team2 WR offset
				printerString += ("The " + team2.getName() + " have an overall wr rank of " + team2.getwrOfRank() + " and are up against The " + team2.getName() + " who have a wr defensive rank of " + team2.getwrDeRank() + "." + "\n");
				//Terrible
				if(team2_WR_Offset >= 2 && team2_WR_Offset <= 16) {
					printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal" + "\n");
				}
				//Bad
				else if(team2_WR_Offset >= 17 && team2_WR_Offset <= 30) {
					printerString += ("With this matchup it is discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal" + "\n");
				}
				//Average
				else if(team2_WR_Offset >= 31 && team2_WR_Offset <= 36) {
					printerString += ("This matchup is close for both teams" + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game" + "\n");
				}
				//Good
				else if(team2_WR_Offset >= 37 && team2_WR_Offset <= 49) {
					printerString += ("With this matchup it is encouraged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score higher than normal" + "\n");
				}
				//Exceptional
				else {
					printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal" + "\n");
				}
				
			// Team2 TE offset
				printerString += ("The " + team2.getName() + " have an overall te rank of " + team2.getteOfRank() + " and are up against The " + team2.getName() + " who have a te defensive rank of " + team2.getteDeRank() + "." + "\n");
				//Terrible
				if(team2_WR_Offset >= 2 && team2_WR_Offset <= 16) {
					printerString += ("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal" + "\n");
				}
				//Bad
				else if(team2_WR_Offset >= 17 && team2_WR_Offset <= 30) {
					printerString += ("With this matchup it is discouarged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal" + "\n");
				}
				//Average
				else if(team2_WR_Offset >= 31 && team2_WR_Offset <= 36) {
					printerString += ("This matchup is close for both teams" + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game" + "\n");
				}
				//Good
				else if(team2_WR_Offset >= 37 && team2_WR_Offset <= 49) {
					printerString += ("With this matchup it is encouraged to pick players from The" + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score higher than normal" + "\n");
				}
				//Exceptional
				else {
					printerString += ("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName() + "\n");
					printerString += ("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal" + "\n");
				}
				return printerString;
		
	}
	
	public static void teamComparison1(int week, int match){
		teams = files.getTeamInfoMap();
		Map <String,String> schedule = files.getSchedule();
		String x = schedule.get("Week "+ week + ":G" + match);
		String w = x.split(" @ ")[0];
		String f = x.split(" @ ")[1].substring(1, x.split(" @ ")[1].length());
		w = NFL.checkString(w, teams);
		//f = NFL.checkString(f, teams);
		Team team1 = teams.get(w);
		Team team2 = teams.get(f);
		System.out.println("Comparing The " + team1.getName() + " vs. The " + team2.getName());
		
		// Offset numbers are from 2 to 64
		// low valued numbers show a bad team/position going against a good team/position defense
		// high valued numbers show a good team/position going against a bad team/position defense
		
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea(450,100);
		
		frame.setSize(500,150);
		frame.add(textArea);
		frame.setVisible(false);
		frame.setTitle("Adding Course Warning"); //RANDOM CODE TO APPEND
		
		
		
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
		
		
		
		// Take a look at the offset for team 1
		textArea.append("Deeper look into The " + team1.getName() + ":\n");
		
		
	// Team1 overall offset
		textArea.append("The " + team1.getName() + " have an overall offensive rank of " + team1.getOffensiveRank() + " and are up against The " + team2.getName() + " who have a defensive rank of " + team2.getDefensiveRank() + ".\n");
		//Terrible
		if(team1_Offensive_Offset >= 2 && team1_Offensive_Offset <= 16) {
			textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName() + "\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal \n");
		}
		//Bad
		else if(team1_Offensive_Offset >= 17 && team1_Offensive_Offset <= 30) {
			textArea.append("With this matchup it is discouarged to pick players from The" + team1.getName() + "\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal\n");
		}
		//Average
		else if(team1_Offensive_Offset >= 31 && team1_Offensive_Offset <= 36) {
			textArea.append("This matchup is close for both teams\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game\n");
		}
		//Good
		else if(team1_Offensive_Offset >= 37 && team1_Offensive_Offset <= 49) {
			textArea.append("With this matchup it is encouraged to pick players from The" + team1.getName() +"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score higher than normal\n");
		}
		//Exceptional
		else {
			textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal\n");
		}
		
	// Team1 QB offset
		textArea.append("The " + team1.getName() + " have an overall qb rank of " + team1.getqbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getqbDeRank() + ".\n");
		//Terrible
		if(team1_QB_Offset >= 2 && team1_QB_Offset <= 16) {
			textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal\n");
		}
		//Bad
		else if(team1_QB_Offset >= 17 && team1_QB_Offset <= 30) {
			textArea.append("With this matchup it is discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal\n");
		}
		//Average
		else if(team1_QB_Offset >= 31 && team1_QB_Offset <= 36) {
			textArea.append("This matchup is close for both teams\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game\n");
		}
		//Good
		else if(team1_QB_Offset >= 37 && team1_QB_Offset <= 49) {
			textArea.append("With this matchup it is encouraged to pick players from The" + team1.getName() +"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score higher than normal\n");
		}
		//Exceptional
		else {
			textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal\n");
		}
		
	// Team1 RB offset
		textArea.append("The " + team1.getName() + " have an overall rb rank of " + team1.getrbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getrbDeRank() + ".\n");
		//Terrible
		if(team1_RB_Offset >= 2 && team1_RB_Offset <= 16) {
			textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal\n");
		}
		//Bad
		else if(team1_RB_Offset >= 17 && team1_RB_Offset <= 30) {
			textArea.append("With this matchup it is discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal\n");
		}
		//Average
		else if(team1_RB_Offset >= 31 && team1_RB_Offset <= 36) {
			textArea.append("This matchup is close for both teams\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game\n");
		}
		//Good
		else if(team1_RB_Offset >= 37 && team1_RB_Offset <= 49) {
			textArea.append("With this matchup it is encouraged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score higher than normal\n");
		}
		//Exceptional
		else {
			textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName() + "\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal\n");
		}
		
	// Team1 WR offset
		textArea.append("The " + team1.getName() + " have an overall wr rank of " + team1.getwrOfRank() + " and are up against The " + team2.getName() + " who have a wr defensive rank of " + team2.getwrDeRank() + ".\n");
		//Terrible
		if(team1_WR_Offset >= 2 && team1_WR_Offset <= 16) {
			textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal\n");
		}
		//Bad
		else if(team1_WR_Offset >= 17 && team1_WR_Offset <= 30) {
			textArea.append("With this matchup it is discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal\n");
		}
		//Average
		else if(team1_WR_Offset >= 31 && team1_WR_Offset <= 36) {
			textArea.append("This matchup is close for both teams\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game\n");
		}
		//Good
		else if(team1_WR_Offset >= 37 && team1_WR_Offset <= 49) {
			textArea.append("With this matchup it is encouraged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score higher than normal\n");
		}
		//Exceptional
		else {
			textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal\n");
		}
		
	// Team1 TE offset
		textArea.append("The " + team1.getName() + " have an overall te rank of " + team1.getteOfRank() + " and are up against The " + team2.getName() + " who have a te defensive rank of " + team2.getteDeRank() + ".\n");
		//Terrible
		if(team1_WR_Offset >= 2 && team1_WR_Offset <= 16) {
			textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much lower than normal\n");
		}
		//Bad
		else if(team1_WR_Offset >= 17 && team1_WR_Offset <= 30) {
			textArea.append("With this matchup it is discouarged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score slightly lower than normal\n");
		}
		//Average
		else if(team1_WR_Offset >= 31 && team1_WR_Offset <= 36) {
			textArea.append("This matchup is close for both teams\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score close to thier average points per game\n");
		}
		//Good
		else if(team1_WR_Offset >= 37 && team1_WR_Offset <= 49) {
			textArea.append("With this matchup it is encouraged to pick players from The" + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score higher than normal\n");
		}
		//Exceptional
		else {
			textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team1.getName()+"\n");
			textArea.append("Fantasy players on The " + team1.getName() + " are expected to score much higher than normal\n");
		}
	
		
		// Take a look at the offset for team 2
		textArea.append("Deeper look into The " + team2.getName() + ":\n");
		
		// Team2 overall offset
		textArea.append("The " + team2.getName() + " have an overall offensive rank of " + team2.getOffensiveRank() + " and are up against The " + team1.getName() + " who have a defensive rank of " + team1.getDefensiveRank() + ".\n");
				//Terrible
				if(team2_Offensive_Offset >= 2 && team2_Offensive_Offset <= 16) {
					textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal\n");
				}
				//Bad
				else if(team2_Offensive_Offset >= 17 && team2_Offensive_Offset <= 30) {
					textArea.append("With this matchup it is discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal\n");
				}
				//Average
				else if(team2_Offensive_Offset >= 31 && team2_Offensive_Offset <= 36) {
					textArea.append("This matchup is close for both teams\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game\n");
				}
				//Good
				else if(team2_Offensive_Offset >= 37 && team2_Offensive_Offset <= 49) {
					textArea.append("With this matchup it is encouraged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score higher than normal\n");
				}
				//Exceptional
				else {
					textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal\n");
				}
				
				// Team2 QB offset
				textArea.append("The " + team2.getName() + " have an overall qb rank of " + team2.getqbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getqbDeRank() + ".\n");
				//Terrible
				if(team2_QB_Offset >= 2 && team2_QB_Offset <= 16) {
					textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal\n");
				}
				//Bad
				else if(team2_QB_Offset >= 17 && team2_QB_Offset <= 30) {
					textArea.append("With this matchup it is discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal\n");
				}
				//Average
				else if(team2_QB_Offset >= 31 && team2_QB_Offset <= 36) {
					textArea.append("This matchup is close for both teams\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game\n");
				}
				//Good
				else if(team2_QB_Offset >= 37 && team2_QB_Offset <= 49) {
					textArea.append("With this matchup it is encouraged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score higher than normal\n");
				}
				//Exceptional
				else {
					textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal\n");
				}
				
			// Team2 RB offset
				textArea.append("The " + team2.getName() + " have an overall rb rank of " + team2.getrbOfRank() + " and are up against The " + team2.getName() + " who have a qb defensive rank of " + team2.getrbDeRank() + ".\n");
				//Terrible
				if(team2_RB_Offset >= 2 && team2_RB_Offset <= 16) {
					textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal\n");
				}
				//Bad
				else if(team2_RB_Offset >= 17 && team2_RB_Offset <= 30) {
					textArea.append("With this matchup it is discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal\n");
				}
				//Average
				else if(team2_RB_Offset >= 31 && team2_RB_Offset <= 36) {
					textArea.append("This matchup is close for both teams\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game\n");
				}
				//Good
				else if(team2_RB_Offset >= 37 && team2_RB_Offset <= 49) {
					textArea.append("With this matchup it is encouraged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score higher than normal\n");
				}
				//Exceptional
				else {
					textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal\n");
				}
				
			// Team2 WR offset
				textArea.append("The " + team2.getName() + " have an overall wr rank of " + team2.getwrOfRank() + " and are up against The " + team2.getName() + " who have a wr defensive rank of " + team2.getwrDeRank() + ".\n");
				//Terrible
				if(team2_WR_Offset >= 2 && team2_WR_Offset <= 16) {
					textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal\n");
				}
				//Bad
				else if(team2_WR_Offset >= 17 && team2_WR_Offset <= 30) {
					textArea.append("With this matchup it is discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal\n");
				}
				//Average
				else if(team2_WR_Offset >= 31 && team2_WR_Offset <= 36) {
					textArea.append("This matchup is close for both teams\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game\n");
				}
				//Good
				else if(team2_WR_Offset >= 37 && team2_WR_Offset <= 49) {
					textArea.append("With this matchup it is encouraged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score higher than normal\n");
				}
				//Exceptional
				else {
					textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal\n");
				}
				
			// Team2 TE offset
				textArea.append("The " + team2.getName() + " have an overall te rank of " + team2.getteOfRank() + " and are up against The " + team2.getName() + " who have a te defensive rank of " + team2.getteDeRank() + ".\n");
				//Terrible
				if(team2_WR_Offset >= 2 && team2_WR_Offset <= 16) {
					textArea.append("With this extreme of a matchup it is strongly discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much lower than normal\n");
				}
				//Bad
				else if(team2_WR_Offset >= 17 && team2_WR_Offset <= 30) {
					textArea.append("With this matchup it is discouarged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score slightly lower than normal\n");
				}
				//Average
				else if(team2_WR_Offset >= 31 && team2_WR_Offset <= 36) {
					textArea.append("This matchup is close for both teams\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score close to thier average points per game\n");
				}
				//Good
				else if(team2_WR_Offset >= 37 && team2_WR_Offset <= 49) {
					textArea.append("With this matchup it is encouraged to pick players from The" + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score higher than normal\n");
				}
				//Exceptional
				else {
					textArea.append("With this extreme of a matchup it is strongly recommended to pick players from The " + team2.getName()+"\n");
					textArea.append("Fantasy players on The " + team2.getName() + " are expected to score much higher than normal\n");
				}
		
	}
	
	
	protected static String checkString(String f, Map<String, Team> teams2) {
		Team team1 = teams2.get(f);
		if (team1 != null) {
			return f;
		}
		else {
			f = f.substring(1, f.length());
			return f;
		}
	}
	
	public void printTeamList() {
		teamNames = files.getTeamMap();
		for (int x = 1; x < teamNames.size(); ++x) {
		  System.out.println(x + " " + teamNames.get(x));
		}
	}
	
	public void printTeamList1() {
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea(450,100);
		
		frame.setSize(500,150);
		frame.add(textArea);
		frame.setVisible(false);
		frame.setTitle("Team List"); //RANDOM CODE TO APPEND
		
		teamNames = files.getTeamMap();
		for (int x = 1; x < teamNames.size(); ++x) {
		  textArea.append(x + " " + teamNames.get(x)+"\n");
		}
	}
	
	public static void printTeamPlayers(int team, int person) {
		players = files.getPlayerMap();
		teamNames = files.getTeamMap();
		ArrayList<Player> player;
		player = new ArrayList<Player>();
		
		if (person == 0) {
			System.out.println("Player Name\tPosition");
		player = players.get(teamNames.get(team));
		for (int y = 0; y < player.size(); ++y) {
		System.out.println((y+1) + " " +player.get(y).getName()+"\t"+player.get(y).getPosition());
		}
		}
		else {
		System.out.println("Name\tPosition\tPlayer Cost\tTeam");	
		System.out.println(player.get(person-1).getName()+"\t"+player.get(person-1).getPosition()+ "\t" + player.get(person-1).getPlayerCost() +"\t"+ player.get(person-1).getTeam());
		}
		}
	
	public static void printTeamPlayers1(int team, int person) {
		players = files.getPlayerMap();
		teamNames = files.getTeamMap();
		ArrayList<Player> player;
		player = new ArrayList<Player>();
		
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea(450,100);
		
		frame.setSize(500,150);
		frame.add(textArea);
		frame.setVisible(false);
		frame.setTitle("Team Players"); //RANDOM CODE TO APPEND
		
		if (person == 0) {
			textArea.append("Player Name\tPosition\n");
		player = players.get(teamNames.get(team));
		for (int y = 0; y < player.size(); ++y) {
			textArea.append((y+1) + " " +player.get(y).getName()+"\t"+player.get(y).getPosition()+"\n");
		}
		}
		else {
			textArea.append("Name\tPosition\tPlayer Cost\tTeam\n");	
			textArea.append(player.get(person-1).getName()+"\t"+player.get(person-1).getPosition()+ "\t" + player.get(person-1).getPlayerCost() +"\t"+ player.get(person-1).getTeam()+"\n");
		}
		}
	
	public void printPositonList() {
		System.out.println("1 Tight End\n2 Wide receivers\n3 Running Back\n4 Quarterback\n5 Defense and Special Teams");
	}
	
	public void printPositonList1() {
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea(450,100);
		
		frame.setSize(500,150);
		frame.add(textArea);
		frame.setVisible(false);
		frame.setTitle("Team List"); //RANDOM CODE TO APPEND
		
		textArea.append("1 Tight End\n2 Wide receivers\n3 Running Back\n4 Quarterback\n5 Defense and Special Teams\n");
	}
		
	public static ArrayList<Player> printPlayerPosition(int team, int position, int numPlayers){
		String[] positionName = new String[]{"Tight End", " Wide receivers","Running Back","Quarterback","Defense and Special Teams", "TE", "WR", "RB", "QB", "DST"}; 
		playerPositions = files.getPlayerPositions();
		teamPositions = files.getTeamPositions();
		teamNames = files.getTeamMap();
		playerList = new ArrayList<Player>();
		
		ArrayList<Player> topPlayers = new ArrayList<Player>();
		
		if (team == 0) {
			if (position == 0) {
				Collections.sort(playerList); 
				playerList = files.getPlayerList();
				for (int x = 0; x <  playerList.size(); ++x) {
					topPlayers.add(playerList.get(x));
				}
			}
			else {
			playerList = playerPositions.get(positionName[position + 4]);
			Collections.sort(playerList);   
			//System.out.println("The List of "+ positionName[position-1]+ " players");
			if (numPlayers < playerList.size()) {
			for (int x = 0; x < numPlayers; ++x) {
				topPlayers.add(playerList.get(x));
			}
			}
			else {
				for (int x = 0; x <  playerList.size(); ++x) {
					topPlayers.add(playerList.get(x)); //+ " " + playerList.get(x).getPlayerCost());
				}
			}
			}
		}
		else {
			playerList = teamPositions.get(teamNames.get(team)).get(positionName[position + 4]);
			Collections.sort(playerList);  
			//System.out.println("The list of "+ positionName[position - 1] + " players for the "+teamNames.get(team)+"s");
			if (numPlayers < playerList.size()) {
				for (int x = 0; x < numPlayers; ++x) {
					topPlayers.add(playerList.get(x));
				}
			}
			else {
			for (int x = 0; x < playerList.size(); ++x) {
				topPlayers.add(playerList.get(x));
			}
			}	
		}
		return topPlayers;
	}
	
	public static void printPlayerPosition1(int team, int position, int numPlayers){
		String[] positionName = new String[]{"Tight End", " Wide receivers","Running Back","Quarterback","Defense and Special Teams", "TE", "WR", "RB", "QB", "DST"}; 
		playerPositions = files.getPlayerPositions();
		teamPositions = files.getTeamPositions();
		teamNames = files.getTeamMap();
		
		playerList = new ArrayList<Player>();
		
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea(450,100);
		
		frame.setSize(500,150);
		frame.add(textArea);
		frame.setVisible(false);
		frame.setTitle("PLayer Position"); //RANDOM CODE TO APPEND
		
		if (team == 0) {
			if (position == 0) {
				Collections.sort(playerList); 
				playerList = files.getPlayerList();
				for (int x = 0; x <  playerList.size(); ++x) {
					textArea.append((x+1)+ " " + playerList.get(x).getName()+"\n");
				}
			}
			else {
			playerList = playerPositions.get(positionName[position + 4]);
			Collections.sort(playerList);   
			//System.out.println("The List of "+ positionName[position-1]+ " players");
			if (numPlayers < playerList.size()) {
			for (int x = 0; x < numPlayers; ++x) {
				textArea.append((x+1)+ " " +playerList.get(x).getName()+"\n");
			}
			}
			else {
				for (int x = 0; x <  playerList.size(); ++x) {
					textArea.append((x+1)+ " " + playerList.get(x).getName()+"\n"); //+ " " + playerList.get(x).getPlayerCost());
				}
			}
			}
		}
		else {
			playerList = teamPositions.get(teamNames.get(team)).get(positionName[position + 4]);
			Collections.sort(playerList);  
			//System.out.println("The list of "+ positionName[position - 1] + " players for the "+teamNames.get(team)+"s");
			if (numPlayers < playerList.size()) {
				for (int x = 0; x < numPlayers; ++x) {
					textArea.append((x+1)+ " " + playerList.get(x).getName()+"\n");
				}
			}
			else {
			for (int x = 0; x < playerList.size(); ++x) {
				textArea.append((x+1)+ " " + playerList.get(x).getName()+"\n");
			}
			}	
		}
	}
	
	
	public static Player getPlayer(int i) {
		return playerList.get(i);
	}
	
	
		
	}
	
