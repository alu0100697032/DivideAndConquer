/**
 * File name:SelectionSort.java
 * Package name: selectionsort
 * Proyect name: DivideAndConquer
 */
package selectionsort;

import java.util.ArrayList;

public class SelectionSort {
	/** 
	 * Atributes
	 */
	private ArrayList<Integer> vector;
	/**
	 * Constructor: SelectionSort
	 */
	public SelectionSort(ArrayList<Integer> vector) {
		setVector(vector);
	}
	/**
	 * sort
	 */
	public ArrayList<Integer> sort() {
		int minimum;
		int aux;
		ArrayList<Integer> sorted = (ArrayList<Integer>) vector.clone();
		for (int i = 0; i < vector.size() - 1; i++) {
			minimum = i;
			for (int j = i+1; j < vector.size(); j++) {
				if(sorted.get(j) < sorted.get(minimum))
					minimum = j;
			}
			aux = sorted.get(i);
			sorted.set(i, sorted.get(minimum));
			sorted.set(minimum, aux);
		}
		return sorted;
	}
	/**
	 * @param vector the vector to set
	 */
	public void setVector(ArrayList<Integer> vector) {
		this.vector = vector;
	}
}
