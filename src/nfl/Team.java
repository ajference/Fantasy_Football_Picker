package nfl;

import java.util.ArrayList;


public class Team {

	//Team Identifiers 
	public String name;
	public ArrayList<Integer> schedule;
	
	
	//Team Rosters
	//FIXME add hash map for each position
	
	
	//Rankings
	public int offensiveRank;
	public int defensiveRank;
	
	
	//Constructors
	public Team () {
			name = "Unknown";
		
		offensiveRank = -999;
		defensiveRank = -999;
	}
	public Team (String teamName, int oRank, int dRank) {
		name = teamName;
		
		offensiveRank = oRank;
		defensiveRank = dRank;
	}
	
	
	//Methods
	public void setName(String string) {
		name = string;
	}
	public String getName() {
		return name;
	}
	
	public void setOffensiveRank(int rank) {
		offensiveRank = rank;
	}
	public int getOffensiveRank() {
		return offensiveRank;
	}
	public void setDefensiveRank(int rank) {
		defensiveRank = rank;
	}
	public int getDefensiveRank() {
		return defensiveRank;
	}
	
	
}
