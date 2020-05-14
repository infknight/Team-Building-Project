// This class inherent from the student class. The most important of this class is that this class creates out CSCE 314 student. This class's constructor consists all the parameter from the person class and student class
// This class constructor have first name, last name, UIN, rank, java knowledge, and section. One of the most important class in java. 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu
public class CSCE314Student extends Student{ // this class is extends from the student 
	// create 2 variable, java knowledge, and section 
	public int javaknowledge;
	public int section; 


	// Constructor right here. Gets the other classes stuff, also set the java knowledge and section as well. 
	public CSCE314Student(String firstname, String lastname, String uIN, Rank rank, int javaknowledge, int section) {
		super(firstname, lastname, uIN, rank);
		this.javaknowledge = javaknowledge;
		this.section = section;
	}
	// getter for java knowledge 
	public int getJavaknowledge() {
		return javaknowledge;
	}
	// setter for java knowledge 
	public void setJavaknowledge(int javaknowledge) {
		this.javaknowledge = javaknowledge;
	}
	
	
	// getter for section 
	public int getSection() {
		return section;
	}
	// setter for section 
	public void setSection(int section) {
		this.section = section;
	}

	@Override
	// this is toString. prints out everything if we just print it. 
	public String toString() {
		return "CSCE314Student [javaknowledge=" + javaknowledge + ", section=" + section + ", UIN=" + UIN + ", rank="
				+ rank + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}




}
