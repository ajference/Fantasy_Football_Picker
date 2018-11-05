package nfl;



public class Team {

	//Team Identifiers 
	public String name;
	
	
	//Team Rosters
	//FIXME add hash map for each position
	
	
	//Rankings
	public int offensiveRank;
	public int defensiveRank;
	
	public int qbOfRank;
	public int qbDeRank;
	
	public int rbOfRank;
	public int rbDeRank;
	
	public int wrOfRank;
	public int wrDeRank;
	
	public int teOfRank;
	public int teDeRank;
	
	
	//Constructors
	public Team () {
		name = "Unknown";
		offensiveRank = -999;
		defensiveRank = -999;		
		qbOfRank = -999;
		qbDeRank = -999;
		rbOfRank = -999;
		rbDeRank = -999;
		wrOfRank = -999;
		wrDeRank = -999;
		teOfRank = -999;
		teDeRank = -999;
	}
	public Team (String teamName, int oRank, int dRank, int qbORank, int qbDRank, int rbORank, int rbDRank, int wrORank, int wrDRank, int teORank, int teDRank) {
		name = teamName;
		offensiveRank = oRank;
		defensiveRank = dRank;
		qbOfRank = qbORank;
		qbDeRank = qbDRank;
		rbOfRank = rbORank;
		rbDeRank = rbDRank;
		wrOfRank = wrORank;
		wrDeRank = wrDRank;
		teOfRank = teORank;
		teDeRank = teDRank;
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
	
	public void setqbOfRank(int rank) {
		qbOfRank = rank;
	}
	public int getqbOfRank() {
		return qbOfRank;
	}
	
	public void setqbDeRank(int rank) {
		qbDeRank = rank;
	}
	public int getqbDeRank() {
		return qbDeRank;
	}
	
	public void setrbOfRank(int rank) {
		rbOfRank = rank;
	}
	public int getrbOfRank() {
		return rbOfRank;
	}
	
	public void setrbDeRank(int rank) {
		rbDeRank = rank;
	}
	public int getrbDeRank() {
		return rbDeRank;
	}
	
	public void setwrOfRank(int rank) {
		wrOfRank = rank;
	}
	public int getwrOfRank() {
		return wrOfRank;
	}	
		
	public void setwrDeRank(int rank) {
		wrDeRank = rank;
	}
	public int getwrDeRank() {
		return wrDeRank;
	}
	
	public void setteOfRank(int rank) {
		teOfRank = rank;
	}
	public int getteOfRank() {
		return teOfRank;
	}
	
	public void setteDeRank(int rank) {
		teDeRank = rank;
	}
	public int getteDeRank() {
		return teDeRank;
	}
}