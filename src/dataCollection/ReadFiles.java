package dataCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import nfl.NFL;
import nfl.Team;

public class ReadFiles {
	
	Map <String,Team> Teams;
	
	public ReadFiles() {
		Teams = new HashMap<String,Team>();
	}
	
	public void readTeamRanks(String[]args) throws FileNotFoundException {
		//Initialize buckets to default
		Team teamTemp;
		//Grab the file and parse data
		Scanner in = new Scanner(new File(args[1]));
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
		Teams.put(teamTemp.getName(), teamTemp);
		}
		
		// Create new team with data and add to NFL teams list
		in.close();
	}

	public Map <String,Team> getTeamsMap() {
		return Teams;
	}
	
}
