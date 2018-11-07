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
	Map <String, HashMap<String, ArrayList<Player>>> TeamPositions;
	HashMap<String, ArrayList<Player>> innerHash;
	Map <String,ArrayList<Player>> PlayerPositions;
	ArrayList<Player> allPlayers;
	
	
	
	
	public ReadFiles() {
		TeamPositions = new HashMap <String, HashMap<String, ArrayList<Player>>>();
		innerHash = new HashMap<String, ArrayList<Player>>();
		teamInfo = new HashMap<String,Team>();
		Players = new HashMap<String,ArrayList<Player>>();
		Teams = new HashMap <Integer, String>();
		PlayerPositions = new HashMap <String,ArrayList<Player>>(); 
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
		ArrayList<Player> player = new ArrayList<Player>();
		ArrayList<Player> te = new ArrayList<Player>();
		ArrayList<Player> rb = new ArrayList<Player>();
		ArrayList<Player> wr = new ArrayList<Player>();
		ArrayList<Player> qb = new ArrayList<Player>();
		ArrayList<Player> dst = new ArrayList<Player>();
		ArrayList<Player> TotalTE = new ArrayList<Player>();
		ArrayList<Player> TotalRB = new ArrayList<Player>();
		ArrayList<Player> TotalWR = new ArrayList<Player>();
		ArrayList<Player> TotalQB = new ArrayList<Player>();
		ArrayList<Player> TotalDST = new ArrayList<Player>();

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
			allPlayers.add(tempPlayer);
			if (fields[1].compareTo("TE") == 0) {
				TotalTE.add(tempPlayer);
				
			}
			else if (fields[1].compareTo("RB") == 0) {
				TotalRB.add(tempPlayer);
				
			}
			else if (fields[1].compareTo("WR") == 0) {
				TotalWR.add(tempPlayer);
				
			}
			else if (fields[1].compareTo("QB") == 0) {
				TotalQB.add(tempPlayer);
				
			}
			else if (fields[1].compareTo("DST") == 0) {
				TotalDST.add(tempPlayer);
				
			}
			 if (temp == null) {
				 temp = fields[2];
			 }
			if (temp.compareTo(fields[2]) == 0) {
				player.add(tempPlayer);
				if (fields[1] == "TE") {
					te.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("RB") == 0) {
					rb.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("WR") == 0) {
					wr.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("QB") == 0) {
					qb.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("DST") == 0) {
					dst.add(tempPlayer);
					
				}
			}
			else {
				Teams.put(count, temp);
				++count;
				Players.put(temp, player);
				innerHash.put("TE",te);
				innerHash.put("RB",rb);
				innerHash.put("WR",wr);
				innerHash.put("QB",qb);
				innerHash.put("DST",dst);
				TeamPositions.put(temp, innerHash);
				temp = fields[2];
				player = new ArrayList<Player>();
				te = new ArrayList<Player>();
				rb = new ArrayList<Player>();
				wr = new ArrayList<Player>();
				qb = new ArrayList<Player>();
				dst = new ArrayList<Player>();
				player.add(tempPlayer);
				if (fields[1] == "TE") {
					te.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("RB") == 0) {
					rb.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("WR") == 0) {
					wr.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("QB") == 0) {
					qb.add(tempPlayer);
					
				}
				else if (fields[1].compareTo("DST") == 0) {
					dst.add(tempPlayer);
					
				}
			}
		}
		PlayerPositions.put("TE",TotalTE);
		PlayerPositions.put("RB",TotalRB);
		PlayerPositions.put("WR",TotalWR);
		PlayerPositions.put("QB",TotalQB);
		PlayerPositions.put("DST",TotalDST);
	}
	
	public Map <String,ArrayList<Player>> getPlayerMap() {
		return Players;
	}
	
	public Map <Integer, String> getTeamMap() {
		return Teams;
	}
	
	public Map <String, HashMap<String, ArrayList<Player>>> getTeamPositions() {
		return TeamPositions;
	}
	
	public Map <String,ArrayList<Player>> getPlayerPositions() {
		return PlayerPositions;
	}
	
	public ArrayList<Player> getPlayerList() {
		return allPlayers;
	}
}
