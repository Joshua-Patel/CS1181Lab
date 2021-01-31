// import java.util.Random;

public class Item{

//	Random rng1 = new Random();
	private final String name;
	private final double weight;
	private final int value;
	private boolean included;

        // Class Construtor with parameters
	public Item(String name, double weight,int value){
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.included = false;
	}
	
	// Constructor to copy items 
	public Item(Item other){
		this.name = other.name;
		this.weight = other.weight;
		this.value = other.value;
		this.included = other.included;
	}


	// ***************** Getters and Setters for attributes *********
	public String getName(){
		return(this.name);
	}

	public double getWeight(){
		return(this.weight);
	}

	public int getValue(){
		return(this.value);
	}

	public boolean isIncluded(){
		return(this.included);
	}

	public void setIncluded(boolean included){
		this.included = included;
	}

	public String toString(){
		return(name + " (" + weight + " lbs, $" + value + ")" );
	}

}
