package nfl;

public class Player implements Comparable<Player> {
	String name;
	String team;
	String position;
	int rank;
	int playerCost;
	
	
	public Player() {
		this.name = "";
		this.team = "";
		this.position = "";
		this.rank = 0; 
		this.playerCost = 0;
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
	public void setPlayerCost(int i) {
		playerCost = i;
	}
	public int getPlayerCost() {
		return playerCost;
	}
	public void setPosition(String i) {
		this.position = i;
	}
	
	public String getPosition() {
		return this.position;
	}
	public void setTeam(String i) {
		this.team = i;
	}
	
	public String getTeam() {
		return this.team;
	}
	@Override
	  public int compareTo(Player player) {  
		if (this.getPlayerCost() < player.getPlayerCost()) {
			return 1; 
		}
		else if (this.getPlayerCost() == player.getPlayerCost()){
			return 0;
		}
		else {
			return -1;
		}
		   
		  }  
	
	
}