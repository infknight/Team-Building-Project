// This is class inherent from the person class. This class is a general student class that stores a student's UIN, and an enum Rank. 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu
public class Student extends Person {
	// inherent from the person class
	// create varaible UIn and rank is the enum rank 
	public String UIN;
	public Rank rank; 
	// getter for UIN 
	public String getUIN() {
		return UIN;
	}
	// setter for UIN 
	public void setUIN(String uIN) {
		UIN = uIN;
	}
	// this is the class constructor. This constructor also uses super to get the person's item 
	public Student(String firstname, String lastname, String uIN, Rank rank) {
		super(firstname, lastname);// use super to get person's varaible. 
		UIN = uIN;
		this.rank = rank; 
	}
	@Override
	// this is toString function that can prints out everything 
	public String toString() {
		return "Student [UIN=" + UIN + ", rank=" + rank + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
