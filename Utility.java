// This class is for file readin and write out. This class read in all the data and stores in an array list. 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu

import java.io.*;
import java.util.*;


public class Utility {
	// create variables tb from team building
	private TeamBuilder tb;
	// string ignore is used to ignore the things I do not need in the csv file. 
	private String ignore; 
	// scanner is used to scann a file from csv 
	private Scanner infile;
	
	// this 2 array list is here to store 2 seperate section's csce 314 students. 
	public ArrayList<CSCE314Student> Students502;
	public ArrayList<CSCE314Student> Students503;
	// filewriter is used to output file 
	private FileWriter output;
	private FileWriter errorout; 
	// constructor is here called to open a file, pass in the a string 
	Utility(String filename){
		openfile(filename);
	}
	// boolean function check if the file opens correctly, throw an file not found exception if error happens. 
	public boolean openfile(String filename) {
		infile = null;
		try {
			// scann iut 
			infile = new Scanner(new FileReader(filename));
		}
		catch (FileNotFoundException e) {
			// throw exception 
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
			return false; 
		}
		// create array list 
		Students502 = new ArrayList<CSCE314Student> ();
		Students503 = new ArrayList<CSCE314Student> ();
		// create some varibles that i need to put it in my CSCE314 students arraylist. 
		int javaknowledge; 
		String fullname;
		String firstn;
		String lastn;
		String section; 
		int sec; 
		String UIN;
		String Rank_; 
		Rank rank;
		// ignore the firsrt line 
  		infile.nextLine(); 
  		// right here readin from the file and stores locally 
		while(infile.hasNextLine()) {
			String line = infile.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(line,",");
			ignore = tokenizer.nextToken(); 
			javaknowledge = Integer.parseInt(tokenizer.nextToken());
			ignore = tokenizer.nextToken(); 
			ignore = tokenizer.nextToken(); 
			// one of the issue I had eariler. there is a , in csv file which is kinda illegal. So I have to check if there are any no statement, if there is i need to get an extra token 
			if (ignore.equals("\"No")) {
				ignore = tokenizer.nextToken();
			}
			// full name token. csv file does not have first name last name. So i have to get full name and parse it. 
			fullname = tokenizer.nextToken();
			// parse the full name to first and last name 
			int idx = fullname.lastIndexOf(' ');
			firstn = fullname.substring(0,idx);
			lastn = fullname.substring(idx+1);
			section = tokenizer.nextToken();
			// parse the first 3 elements of the section 
			sec = Integer.parseInt(section.substring(0,3));
			UIN = tokenizer.nextToken();
			// parse the first 10 element of UIN 
			UIN = UIN.substring(0,10);
			Rank_ = (tokenizer.nextToken());
			// rank has 3 wrong things. it has an error, it has a 0, and it has a -2. All those 3 should be logged to another file. It should not be considered as part of the team. 
			if (Rank_.equals("ERROR")) {
				try (FileWriter fw = new FileWriter("error.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)){
					out.write(fullname); 
					out.write(" has a error rank"); 
					out.write("\n");
					out.close();
				}
				catch (IOException e){
					System.out.println("File not found");
					e.printStackTrace();
					System.exit(0);
				}
				continue;// write to file again 
			}
			if(Rank_.equals("0")) {
				try (FileWriter fw = new FileWriter("error.txt",false);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)){
					out.write(fullname);
					out.write(" has a rank 0. ");
					out.write("\n");
					out.close();
					
				}
				catch (IOException e){
					System.out.println("File not found");
					e.printStackTrace();
					System.exit(0);
				}
				continue; // skip continue 
			}
			if (Rank_.equals("-2")) {
				try (FileWriter fw = new FileWriter("error.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)){
					out.write(fullname);
					out.write(" has a rank -2. ");
					out.write("\n");
					out.close();
					
				}
				catch (IOException e){
					System.out.println("File not found");
					e.printStackTrace();
					System.exit(0);
				}
				continue;
			}
			// call the enum parse int 
			int rank_ = Integer.parseInt(Rank_);
			rank = Rank.parseRank(rank_);
			CSCE314Student stu = new CSCE314Student(firstn, lastn, UIN, rank, javaknowledge, sec); 
			// put the students in different sections 
			if(sec == 502) {
				Students502.add(stu);
			}
			else {
				Students503.add(stu);
			}
			
		}
		// close the file 
		infile.close();
		return true;
	}
	// create a getter function for arraylist so I can use them in teambuild
	public ArrayList<CSCE314Student> get502(){
		return Students502;
	}
	
	public ArrayList<CSCE314Student> get503(){
		return Students503; 
	}

	
	// this is write to file 
	public boolean writefile() {
		tb = new TeamBuilder();
		tb.buildteam();
		// create a new arraylist of pairs and calles the getter from teambuild. 
		ArrayList<Pair> team = new ArrayList(tb.get_team());
		output = null; 


			
		// write my output to a file called result. 
		try {
			output= new FileWriter("result.txt",false);
			// out put everything to file. Create 2 instance of CSCE314 student. 
			for (int i = 0; i < team.size() ; i++) {
				// get the first student of pair and second student of pair 
				CSCE314Student a = (CSCE314Student) team.get(i).getfirst();
				CSCE314Student b = (CSCE314Student) team.get(i).getsecond();

				// get all the information that I want to print to a file 
				int sec = a.getSection();
				String fn = a.getFirstname();
				String ln = a.getLastname();
				int jk = a.getJavaknowledge();
				
				// in the file i have a null because section 503 is odd number. So I put the null as a pair with a student
				// later i will insert this student. 
				// I also made sure this student is a middle student. And this student should be a sub 
				if(b == null) {
					continue; 
				}
				String fnb = b.getFirstname();
				String lnb = b.getLastname();
				int jkb = b.getJavaknowledge();
				
				// write to a file 
				output.write(String.valueOf(sec));
				output.write(" - ");
				output.write(fn);
				output.write(" ");
				output.write(ln);
				output.write(" (");
				output.write(String.valueOf(jk));
				output.write(") ");
//				
				output.write(fnb);
				output.write(" ");
				output.write(lnb);
				output.write(" (");
				output.write(String.valueOf(jkb));
				output.write(") ");
				output.write("\n"); 

				
			}			
			// right here is where I prints out the last student's information
			
			CSCE314Student last = (CSCE314Student) team.get(team.size()-1).getfirst();
			int last_sec = last.getSection();
			String last_f = last.getFirstname();
			String last_l = last.getLastname();
			int last_jk = last.getJavaknowledge();
			output.write(String.valueOf(last_sec));
			output.write(" - ");
			output.write(last_f);
			output.write(" ");
			output.write(last_l);
			output.write(" (");
			output.write(String.valueOf(last_jk));
			output.write(") ");
			output.write(" (Subsitutition) ");

			// close file and return true. 
			output.close();
			return true; 
		} 
		catch (IOException e){
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
			return false; 
		}
	}
	
}
	

