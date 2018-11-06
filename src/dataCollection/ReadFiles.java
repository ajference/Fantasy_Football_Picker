package dataCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import nfl.NFL;
import nfl.Player;
import nfl.Team;

public class ReadFiles {
	
	Map <String,Team> teamInfo;
//	Map<String,String> teamToPos;
	Map <String,ArrayList<Player>> Players;
	Map <Integer, String> Teams;
	
	
	
	
	public ReadFiles() {
		teamInfo = new HashMap<String,Team>();
		Players = new HashMap<String,ArrayList<Player>>();
		Teams = new HashMap <Integer, String>();
	}
	
	public void readTeamRanks() throws FileNotFoundException {
		//Initialize buckets to default
		Team teamTemp;
		//Grab the file and parse data
		File location  = new File("");
		Scanner in = new Scanner(new File(location.getAbsolutePath() + "/src/input_files/TeamNames.txt"));
		while(in.hasNextLine()) {
			 teamTemp = new Team();
			String line = in.nextLine();
			String[] fields = line.split(",");
			
			teamTemp.setName(fields[0]);
		teamTemp.setOffensiveRank(Integer.valueOf(fields[1]));
		teamTemp.setDefensiveRank(Integer.valueOf(fields[2]));
		teamTemp.setqbOfRank(Integer.valueOf(fields[3]));
		teamTemp.setqbDeRank(Integer.valueOf(fields[4]));
		teamTemp.setrbOfRank(Integer.valueOf(fields[5]));
		teamTemp.setrbDeRank(Integer.valueOf(fields[6]));
		teamTemp.setwrOfRank(Integer.valueOf(fields[7]));
		teamTemp.setwrDeRank(Integer.valueOf(fields[8]));
		teamTemp.setteOfRank(Integer.valueOf(fields[9]));
		teamTemp.setteDeRank(Integer.valueOf(fields[10]));
		teamInfo.put(teamTemp.getName(), teamTemp);
		}
		
		// Create new team with data and add to NFL teams list
		in.close();
	}

	public Map <String,Team> getTeamInfoMap() {
		return teamInfo;
	}
	
	public void readPlayerStats() throws FileNotFoundException {
		int count = 1;
		String temp = null;
		ArrayList<Player> player;
		player = new ArrayList<Player>();
		//Initialize buckets to default
		Player tempPlayer;
		//Grab the file and parse data
		File location  = new File("");
		Scanner in = new Scanner(new File(location.getAbsolutePath() + "/src/input_files/PlayerRosterNFL.txt"));
		while(in.hasNextLine()) {
			 tempPlayer = new Player();
			String line = in.nextLine();
			String[] fields = line.split(",");
			
			tempPlayer.setPlayerCost(Integer.valueOf(fields[0]));
			tempPlayer.setPosition(fields[1]);
			tempPlayer.setTeam(fields[2]);
			tempPlayer.setName(fields[3]);
			 if (temp == null) {
				 temp = fields[2];
			 }
			if (temp == fields[2]) {
				player.add(tempPlayer);
			}
			else {
				Teams.put(count, temp);
				++count;
				Players.put(temp, player);
				temp = fields[2];
				player = new ArrayList<Player>();
				player.add(tempPlayer);
			}
		}
	}
	
	public Map <String,ArrayList<Player>> getPlayerMap() {
		return Players;
	}
	
	public Map <Integer, String> getTeamMap() {
		return Teams;
	}
	
	
}
