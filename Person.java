// this classes stores the first name, last name. This class is also an abstract class. Most importantly, this class is a base class. This class is an abstract class creates a person 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu
public abstract class Person { // our base class, this is an abstract class
	// create a string first name and last name
	public String firstname;
	public String lastname;
	// getter to get firstname
	public String getFirstname() {
		return firstname;
	}
	// setter to set firstname
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	//getter to get last name
	public String getLastname() {
		return lastname;
	}
	// setter to set first name; 
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	// this is the toString. Convert things that can print. 
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	// this is the constructor for person. 
	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	} 
	
	
}
