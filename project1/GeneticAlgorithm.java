import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Collections;

public class GeneticAlgorithm{
	
	// This method reads Items from given Text File
	public static ArrayList<Item> readData(String filename) throws FileNotFoundException{
		File f = new File(filename);
		Scanner sc = new Scanner(f);	
		ArrayList<Item> items = new ArrayList<>();
		while(sc.hasNext()){
			String input = sc.nextLine();
			String[] values = input.split(", ");
			String name = values[0];
                        double weight = Double.parseDouble(values[1]);
                        int value = Integer.parseInt(values[2]);
			Item obj = new Item(name, weight, value);
			items.add(obj);
		}
		return items;
	}

	// Createing initial populatin of chromosome by intantiating Chormosome class
	public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize){
		ArrayList<Chromosome> chromo = new ArrayList<>();
		for(int i=0; i<populationSize; i++){
			Chromosome obj = new Chromosome(items);
			chromo.add(obj);
		}
		return chromo;
	}

	public static void main(String[] args) throws FileNotFoundException{
		
		// Initial population
		ArrayList<Item> items = new ArrayList<>();
		items = readData("items.txt");

		ArrayList<Chromosome> population = new ArrayList<>();
		population = initializePopulation(items, 10);

	//	for(int i=0; i<initialPopulation.size(); i++){
	//		System.out.println(initialPopulation.get(i).toString());
	//	}


		// Creating new Generation
		// adding patrents
		ArrayList<Chromosome> newGeneration = new ArrayList<>();

		int generation = 0;
		do{
		for(int i=0; i<population.size(); i++){
			Chromosome Parent = new Chromosome();
			Parent = population.get(i);
			newGeneration.add(Parent);
		}

		//adding children
		Random randomIndex = new Random();
		for(int i=0; i<15; i+=2){
			int parent1 = randomIndex.nextInt(population.size()-1);
			int parent2 = randomIndex.nextInt(population.size()-1);
			if(parent1 == parent2)
				parent2 = parent1 + 1;

			newGeneration.add(newGeneration.get(parent1).crossover(newGeneration.get(parent2)));
		}

		// *** Uncomment this part to check elements of new generation
		// -----------------------------------------------------------
		//for(int i=0; i<newGeneration.size(); i++){
                //        System.out.println(newGeneration.get(i).toString());
                //}
		//------------------------------------------------------------

		Collections.sort(newGeneration);

		// *** Uncomment this to check implementation of Comparable
		// ----------------------------------------------------------------
	        //for(int i=0; i<newGeneration.size(); i++){
                //     System.out.println(newGeneration.get(i).toString());
                //}
		//-----------------------------------------------------------------
		
		
		// **** Clear the contents of current population 'mass genocide':)
		population.clear();

		// Adding the ten Fittest chromosomes of the sorted new generation to the new population
		for(int i=0; i<10; i++){
			Chromosome fitChromo = new Chromosome();
			fitChromo = newGeneration.get(i);
			population.add(fitChromo);
		}

		newGeneration.clear();
		
		generation++;
		}while (generation<2);

		//*** Uncomment to check the final population
		//-------------------------------------------------------------
		//for(int i=0; i<population.size(); i++){
                //        System.out.println(population.get(i).toString());
                //}
		//-------------------------------------------------------------

		System.out.println("The Fittest individual has:");
		System.out.println(population.get(0).toString());
			
	}

}
