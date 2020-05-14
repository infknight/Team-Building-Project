// This class a simple comparator, it compares the java knowledge. 
// Zixuan Jia
// 227006636
// jasonjia@tamu.edu
import java.util.Comparator; 
// very basic class compares student's java knowledge. 
public class JavaKnowledgeComparator implements Comparator<CSCE314Student>{

	@Override
	// use comparator to do it because it is way easier because it is in another class. 
	public int compare(CSCE314Student o1, CSCE314Student o2) {
		// compare if it is greater ir kess 
		if(o1.getJavaknowledge() < o2.getJavaknowledge()) {
			return -1;
		}
		else if(o1.getJavaknowledge() > o2.getJavaknowledge()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
