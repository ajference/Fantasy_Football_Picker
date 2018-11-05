package dataCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import nfl.NFL;
import nfl.Team;

public class ReadFiles {
	
	
	
	
	public void readTeamRanks(String[]args) throws FileNotFoundException {
		//Initialize buckets to default
		String teamName = "Unknown";
		int oRank = -999;
		int dRank = -999;
		int qbORank = -999;
		int qbDRank = -999;
		int rbORank = -999;
		int rbDRank = -999;
		int wrORank = -999;
		int wrDRank = -999;
		int teORank = -999;
		int teDRank = -999;
		
		//Grab the file and parse data
		Scanner in = new Scanner(new File(args[1]));
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			String[] fields = line.split(",");
			
			teamName = fields[0];
			oRank   = Integer.valueOf(fields[1]);
			dRank   = Integer.valueOf(fields[2]);
			qbORank = Integer.valueOf(fields[3]);
			qbDRank = Integer.valueOf(fields[4]);
			rbORank = Integer.valueOf(fields[5]);
			rbDRank = Integer.valueOf(fields[6]);
			wrORank = Integer.valueOf(fields[7]);
			wrDRank = Integer.valueOf(fields[8]);
			teORank = Integer.valueOf(fields[9]);
			teDRank = Integer.valueOf(fields[10]);
		}
		
		// Create new team with data and add to NFL teams list
		NFL.addTeam(new Team(teamName, oRank, dRank, qbORank, qbDRank, rbORank, rbDRank, wrORank, wrDRank, teORank, teDRank));
		in.close();
	}

	
	
}
