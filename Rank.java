// This class is a enum class, Freshman 1, Sophomore 2, etc. 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu
public enum Rank {
	Freshman(1), 
	Sophomore(2), 
	Junior(3), 
	Senior(4);
	// create a enum for each grade. 
	
	public int rankv;
	
	// this is the constructor for other class to use. Pass a integer, and get an enum 
	Rank(int rankv) {
		this.rankv = rankv;
	}
	
	// getter 
	public int getRank() {
		return this.rankv; 
	}
	
	
	// this is how we parse it. 
	public static Rank parseRank(int i) {
		// use a switch case for getting the freshman or sophomore, or junior, or senior. 
		switch(i) {
		case 1:
			return Freshman;
		case 2:
			return Sophomore;
		case 3:
			return Junior;
		case 4:
			return Senior; 
		}
		// return a null if it is none of the situation. However, my data would not have any other data than 1 2 3 4. 
		return null;
	}
	
}
