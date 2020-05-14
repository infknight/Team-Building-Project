// This class is for file readin and write out. This class read in all the data and stores in an array list. 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu

public class Pair<F,S> { // create a generic pair 
	// create 2 generic variable s1 and s2 that can store anything as a pair.
	public F s1;
	public S s2;
	
	// constructor that construct 2 variables to a pair
	public Pair(	F s1,S s2) {
		this.s1 = s1;
		this.s2 = s2; 
	}
	
	// this is what i need to get the first one
	public F getfirst() {
		return s1;
	}
	
	// this is get the second one 
	public S getsecond() {
		return s2;
	}
	
	// setter for first one 
	public void setfirst(F s1) {
		this.s1 = s1;
	}
	
	// setter for second one 
	public void setsecond(S s2) {
		this.s2 = s2; 
	}

	// lovely tostring function that I might use, but i doubt it 
	@Override
	public String toString() {
		return "Pair [student 1=" + s1 + ", student 2 =" + s2 + "]";
	}
	
	
}
