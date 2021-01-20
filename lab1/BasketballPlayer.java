public class BasketballPlayer implements Comparable<BasketballPlayer> {

	private String firstName;
	private String lastName;
	private double ppg;

	public BasketballPlayer(String first, String last, double ppg) { 
		this.firstName = first;
		this.lastName = last;
		this.ppg = ppg;
	}

	public String toString() {
		return lastName + ", " + firstName + " (" + ppg + ") ";
	}

	public int compareTo(BasketballPlayer bp){
		if(this.ppg > bp.ppg){
		return -1;
		}
		else if(this.ppg < bp.ppg){
		return 1;
		}
		else{
			if(this.lastName.compareTo(bp.lastName)==1){
			return 1;
			}
			else if(this.lastName.compareTo(bp.lastName)==-1){
			return -1;
			}
			else{
			return this.firstName.compareTo(bp.firstName);
			}
		}
	}
}	
