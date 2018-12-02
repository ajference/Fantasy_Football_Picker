package dataCollection;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nfl.NFL;
import nfl.Player;
import nfl.Team;

public class CalculateRanks extends NFL {
	
	
	public CalculateRanks() throws FileNotFoundException {
		super();
	}
	
	public static String makeBreakDown(int week) {
		String printerString = "";
		
		teams = files.getTeamInfoMap();
		ArrayList<Team> teamList = new ArrayList<Team>();
		List<Integer> numGames = files.getNumGames();
		Map <String,String> schedule = files.getSchedule();
		ArrayList<Player> players = new ArrayList<Player>();
		for (int match = 0; match < numGames.get(week -1); ++match) {
		String x = schedule.get("Week "+ week + ":G" + (match+1));
		String w = x.split(" @ ")[0];
		String f = x.split(" @ ")[1].substring(1, x.split(" @ ")[1].length());
		w = NFL.checkString(w, teams);
		teamList.add(teams.get(w));
		teamList.add(teams.get(f));
		Team team1 = teams.get(w);
		Team team2 = teams.get(f);
		
		
		team1.setQB_Offset(33-team1.getqbOfRank()+team2.getqbDeRank());
		team2.setQB_Offset(33-team2.getqbOfRank()+team1.getqbDeRank());
		
		team1.setRB_Offset(33-team1.getrbOfRank()+team2.getrbDeRank()); 
		team2.setRB_Offset(33-team2.getrbOfRank()+team1.getrbDeRank());
		
		team1.setWR_Offset(33-team1.getwrOfRank()+team2.getwrDeRank());
		team2.setWR_Offset(33-team2.getwrOfRank()+team1.getwrDeRank());
		
		team1.setTE_Offset(33-team1.getteOfRank()+team2.getteDeRank());
		team2.setTE_Offset(33-team2.getteOfRank()+team1.getteDeRank());
		}
		int i = 0;
		int j = 0;
		
		int QBnum = 0;
		int RBnum = 0;
		int WRnum = 0;
		int TEnum = 0;
		
		printerString += ("Here are the best QB's to pick from based on their matchup in week " + week + "\n");
		printerString += ("~The Player -- Their Team~" + "\n");
		// Finds the top QB's to pick
		for(i = 62; i >= 2; i--) {
			for(j = 0; j < teamList.size(); j++) {
				if(teamList.get(j).getQB_Offset() == i) {
					players = files.getTeamPositions().get(teamList.get(j).getName()).get("QB");
					Collections.sort(players);
					printerString += (players.get(0).getName() + "--" + players.get(0).getTeam() + "\n");
					QBnum++;
				}
			}
			if(QBnum >= 3) {
				break;
			}
		}
		
		printerString += ("\nHere are the best RB's to pick from based on their matchup in week " + week + "\n");
		printerString += ("~The Player -- Their Team~" + "\n");
		// Finds the top RB's to pick
		for(i = 62; i >= 2; i--) {
			for(j = 0; j < teamList.size(); j++) {
				if(teamList.get(j).getRB_Offset() == i) {
					players = files.getTeamPositions().get(teamList.get(j).getName()).get("RB");
					Collections.sort(players);
					printerString += (players.get(0).getName() + "--" + players.get(0).getTeam() + "\n");
					RBnum++;
				}
			}
			if(RBnum >= 4) {
				break;
			}
		}
		
		printerString += ("\nHere are the best WR's to pick from based on their matchup in week " + week + "\n");
		printerString += ("~The Player -- Their Team~" + "\n");
		// Finds the top WR's to pick
		for(i = 62; i >= 2; i--) {
			for(j = 0; j < teamList.size(); j++) {
				if(teamList.get(j).getWR_Offset() == i) {
					players = files.getTeamPositions().get(teamList.get(j).getName()).get("WR");
					Collections.sort(players);
					printerString += (players.get(0).getName() + "--" + players.get(0).getTeam() + "\n");
					WRnum++;
				}
			}
			if(WRnum >= 6) {
				break;
			}
		}
		
		printerString += ("\nHere are the best TE's to pick from based on their matchup in week " + week + "\n");
		printerString += ("~The Player -- Their Team~" + "\n");
		// Finds the top TE's to pick
		for(i = 62; i >= 2; i--) {
			for(j = 0; j < teamList.size(); j++) {
				if(teamList.get(j).getTE_Offset() == i) {
					players = files.getTeamPositions().get(teamList.get(j).getName()).get("TE");
					Collections.sort(players);
					printerString += (players.get(0).getName() + "--" + players.get(0).getTeam() + "\n");
					TEnum++;
				}
			}
			if(TEnum >= 4) {
				break;
			}
		}
		return printerString;
	}
	
	
	
	
	
}
