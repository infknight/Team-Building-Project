// this is the code where we going to put all the team here. What is most important is we get tje arraylist from utility, sort it, and build a team as pair.
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu
import java.util.*;

public class TeamBuilder {
	// create an instance of utility to get the utility's arraylist 
	private Utility ut;
	// create an arraylist of pairs to pair students into teams 
	public ArrayList<Pair> teambuild = new ArrayList<Pair> (); 
	// this class constructor just call the build team function. 
	
	
	TeamBuilder(){
		buildteam();
	}
	public ArrayList<Pair> getTeambuild() {
		return teambuild;
	}
	public void setTeambuild(ArrayList<Pair> teambuild) {
		this.teambuild = teambuild;
	}
	public void buildteam() {
		String csvfile1 ="CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv";
		// calls the utility constructor 
		ut = new Utility(csvfile1);	
		// get the arraylist from utility 
		ArrayList<CSCE314Student> new_502 = ut.get502();
		ArrayList<CSCE314Student> new_503 = ut.get503();
		// use collection.sort to sort this thing 
		Collections.sort(new_502, new JavaKnowledgeComparator());
		Collections.sort(new_503, new JavaKnowledgeComparator());
		// check if this pair is even or odd 
		if(new_502.size()%2 == 0) { // if this is even just pair the first and last 
			for (int i = 0; i < new_502.size()/2;i++) {
				CSCE314Student low = new_502.get(i);
				CSCE314Student high = new_502.get(new_502.size()-i-1);
				Pair team = new Pair(low, high); 
				teambuild.add(team); 
			}	
		}
		// if it is not even, just takes the middle one as sub, pair the rest 
		else {
			CSCE314Student mid = new_502.get(new_502.size()/2);
			Pair sub = new Pair(mid,null);
			for (int i = 0; i < new_502.size()/2;i++) {
				CSCE314Student low = new_502.get(i);
				CSCE314Student high = new_502.get(new_502.size()-i-1);
				Pair team = new Pair(low, high); 
				teambuild.add(team); 
			}	
			teambuild.add(sub);
		}

		
		// this part is for section 503 
		// same idea check if it is even of odd, etc. 
		if(new_503.size()%2 == 0) {
			for (int i = 0; i < new_503.size()/2;i++) {
				CSCE314Student low = new_503.get(i);
				CSCE314Student high = new_503.get(new_503.size()-i-1);
				Pair team = new Pair(low, high); 
				teambuild.add(team); 
			}	
		}
		else {
			CSCE314Student mid = new_503.get(new_503.size()/2);
			Pair sub = new Pair(mid,null);
			for (int i = 0; i < new_503.size()/2;i++) {
				CSCE314Student low = new_503.get(i);
				CSCE314Student high = new_503.get(new_503.size()-i-1);
				Pair team = new Pair(low, high); 
				teambuild.add(team); 
			}	
			teambuild.add(sub);
		}
	}
	
	// method to get the pair to use for wirte to file in utility 
	public ArrayList<Pair> get_team(){
		return teambuild;
	}
	
	@Override
	public String toString() {
		return "TeamBuilder [teambuild=" + teambuild + "]";
	}
	// create a call that calls the write file in driver 
	public void call() {
		ut.writefile(); 
	}
	
	
	
}
	
