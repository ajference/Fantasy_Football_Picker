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
		Scanner in = new Scanner(new File(args[0] +" "+ args[1]));
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
	
	public static void main(String[] args) throws FileNotFoundException {
		NFL temp = new NFL();
		temp.buildNFL(args);
		temp.printWeeklySchedule(17);

	}
	
	
}
