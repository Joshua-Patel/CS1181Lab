import java.util.Random;
import java.util.ArrayList;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome>{

	// Using this for Generating Random Numbers
	private static Random rng = new Random();

	
	// Empyt Constructor for the class
	public Chromosome(){
		
	}

	// Class Constructor to copy Item and to set 'Included' to T/F
	public Chromosome(ArrayList<Item> items){
		//**** Copy Items
		for(int i=0; i<items.size(); i++){
			Item copyItem = new Item(items.get(i));
			this.add(copyItem);
		}

		//**** Set Included to True or False as per Random Number
		for(int i=0; i<this.size(); i++){
			int randomInt = rng.nextInt(2);
			if(randomInt==1){
                                this.get(i).setIncluded(true);
			}
                        else{
                                this.get(i).setIncluded(false);
			}
		}
	}
	
	// To Create Child using two chromose as cross-over
	public Chromosome crossover(Chromosome other){
		Chromosome child = new Chromosome();
		for(int i=0; i<this.size(); i++){
			int randomInt = rng.nextInt(10);
			if(randomInt < 5){
				child.add(this.get(i));
				child.get(i).setIncluded(this.get(i).isIncluded());
			}

			else{
				child.add(other.get(i));
				child.get(i).setIncluded(other.get(i).isIncluded());
			}
		}
		// **** Call Mutate method with 10% Chance to mutate
		child.mutate();
		return(child);
	}

	// This is mutate method with 10% Chance
	public void mutate(){
		for(int i=0; i<this.size(); i++){
			if(rng.nextInt(10)==1){
				if(this.get(i).isIncluded()==true)
					this.get(i).setIncluded(false);
				else
					this.get(i).setIncluded(true);
			}
		}
	}

	// Method to calculate fitness of chromosome
	public int getFitness(){
		double weight=0.0;
		int fitValue=0;
		for(int i=0; i<this.size(); i++){
			if(this.get(i).isIncluded()==true){
				weight += this.get(i).getWeight();
				fitValue += this.get(i).getValue();
			}
		}
		if(weight>10.0)
			return 0;
		else
			return fitValue;
	}

	// Implementation of Comparable
	public int compareTo(Chromosome other){
		int comparision;
		if(this.getFitness()>other.getFitness())
			comparision = -1;
		else if(this.getFitness()<other.getFitness())
			comparision = 1;
		else
			comparision = 0;

		return comparision;
	}

	
	public String toString(){
		for(int i=0; i<this.size(); i++){
			if(this.get(i).isIncluded()==true){
				System.out.println(this.get(i).getName()+"   "+this.get(i).getWeight()+" lbs   $"+this.get(i).getValue());
			}
		}
		return(this.getFitness()+"");	
	}
	
}
