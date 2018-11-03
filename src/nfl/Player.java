package nfl;

public class Player {
	String name;
	String team;
	int rank;
	
	
	public Player() {
		this.name = "";
		this.team = "";
		this.rank = 0; 
	}
	
	public void setName(String i) {
		this.name = i;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setRank(int i) {
		this.rank = i;
	}
	public int getRank() {
		return this.rank;
	}
	
	
}