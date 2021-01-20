import java.util.*;

public class Driver{
	public static void main(String[] args){
		BasketballPlayer bp1 = new BasketballPlayer("Jay", "Smith", 12.7);
		BasketballPlayer bp2 = new BasketballPlayer("DeShaun", "Smith", 12.7);
		BasketballPlayer bp3 = new BasketballPlayer("DeShaun", "Taylor", 18.1);

		ArrayList<BasketballPlayer> arr = new ArrayList<BasketballPlayer>();

		arr.add(bp1);
		arr.add(bp2);
		arr.add(bp3);

		System.out.println(arr);

		Collections.sort(arr);

		System.out.println(arr);
	}
}
