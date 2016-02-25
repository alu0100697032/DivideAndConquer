/**
 * File name:Main.java
 * Package name: framework
 * Proyect name: DivideAndConquer
 */
package global;

import java.util.ArrayList;
import java.util.Random;

import framework.Solution;
import maximum.Maximum;
import maximum.MaximumDescription;
import mergesort.MergeSort;
import mergesort.MergeSortDescription;
import minimum.Minimum;
import minimum.MinimumDescription;
import selectionsort.SelectionSort;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		ArrayList<Integer> mergeCounters = new ArrayList<>(); 
		ArrayList<Integer> selectionCounters = new ArrayList<>(); 
		int problemSize = 10;
		int numberOfTests = 10;
		String output = "Problem size: " + problemSize + "\n";
		/**
		 * Random tests
		 */
		ArrayList<ArrayList<Integer>> testVectors = new ArrayList<>();
		for (int i = 0; i < numberOfTests; i++) {
			ArrayList<Integer> unsortedVector = new ArrayList<>();
			for (int j = 0; j < problemSize; j++) {
				unsortedVector.add(random.nextInt(100));
			}
			testVectors.add(unsortedVector);
		}
		System.out.println("Test 1");
		System.out.println("Disordered:\t" + testVectors.get(0));
		
		MergeSort mergesort = new MergeSort();
		MergeSortDescription mergeSortDescription = new MergeSortDescription(testVectors.get(0));
		Solution solution = mergesort.solve(mergeSortDescription);
		mergeCounters.add(mergeSortDescription.getCounter());
		System.out.println("Merge sort:\t" + ((MergeSortDescription)solution).vectorToString());
		
		SelectionSort selectionSort = new SelectionSort(testVectors.get(0));
		System.out.println("Selection sort:\t" + selectionSort.sort());
		selectionCounters.add(selectionSort.getCounter());
		
		Maximum maximum = new Maximum();
		MaximumDescription maximumDescription = new MaximumDescription(testVectors.get(0));
		Solution maximumSolution = maximum.solve(maximumDescription);
		System.out.println("Maximum: " + ((MaximumDescription)maximumSolution).getMaximum());
		
		for (int i = 1; i < testVectors.size() ;i++) {
			System.out.println("Test " + (i + 1));
			System.out.println("Disordered:\t" + testVectors.get(i));
			
			mergeSortDescription.resetMergeSort(testVectors.get(i));
			solution = mergesort.solve(mergeSortDescription);
			mergeCounters.add(mergeSortDescription.getCounter());
			System.out.println("Merge sort:\t" + ((MergeSortDescription)solution).vectorToString());
			
			selectionSort.resetVector(testVectors.get(i));
			System.out.println("Selection sort:\t" + selectionSort.sort());
			selectionCounters.add(selectionSort.getCounter());
			
			maximumDescription.resetMaximum(testVectors.get(i));
			maximumSolution = maximum.solve(maximumDescription);
			System.out.println("Maximum: " + ((MaximumDescription)maximumSolution).getMaximum());
			
		}
		/**
		 * Merge
		 */
		Minimum minimum = new Minimum();
		int mergeAverage = 0, selectionAverage = 0, minimumMergeCounters, minimumSelectionCounters,
				maximumMergeCounters, maximumSelectionCounters;
		
		MinimumDescription minimumDescription = new MinimumDescription(mergeCounters);
		minimum.solve(minimumDescription);
		minimumMergeCounters = minimumDescription.getMinimum();
		maximumDescription.resetMaximum(mergeCounters);
		maximum.solve(maximumDescription);
		maximumMergeCounters = maximumDescription.getMaximum();
		//AVG
		for(int i = 0; i < mergeCounters.size(); i++)
			mergeAverage += mergeCounters.get(i);
		mergeAverage /= mergeCounters.size();
		/**
		 * Selection
		 */
		minimumDescription.resetMinimum(selectionCounters);
		minimum.solve(minimumDescription);
		minimumSelectionCounters = minimumDescription.getMinimum();
		maximumDescription.resetMaximum(selectionCounters);
		maximum.solve(maximumDescription);
		maximumSelectionCounters = maximumDescription.getMaximum();
		//AVG
		for(int i = 0; i < selectionCounters.size(); i++)
			selectionAverage += selectionCounters.get(i);
		selectionAverage /= selectionCounters.size();
		
		output += "Merge sort:\n" + mergeCounters.toString() 
		+ "\n Minimum: " + minimumMergeCounters
		+ "\n Maximum: " + maximumMergeCounters 
		+ "\n Average: " + mergeAverage;
		
		output += "\nSelection sort:\n" + selectionCounters.toString() 
		+ "\n Minimum: " + minimumSelectionCounters 
		+ "\n Maximum: " + maximumSelectionCounters
		+ "\n Average: " + selectionAverage;
		
		WriteFile writeFile = new WriteFile();
		writeFile.write("src/output.txt", output);
	}
}
