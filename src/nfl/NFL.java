package nfl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NFL {
	Map <String,String> schedule;
	public NFL() {
		schedule = new HashMap<String,String>();
	}
	public void buildNFL (String[]args) throws FileNotFoundException {
		int count = 1; 
		Scanner in = new Scanner(new File(args[0]));
		while (in.hasNextLine()){
			String line = in.nextLine();
			String[] feilds = line.split(",");
			for (int j = 1; j < feilds.length - 1; j++) {
			schedule.put(feilds[0] + "G" + count, feilds[j]);
			count ++;
			}
			count = 1;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		NFL temp = new NFL();
		temp.buildNFL(args);
	}
	
	
}
