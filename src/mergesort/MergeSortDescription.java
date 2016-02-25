/**
 * File name:MergeSortDescription.java
 * Package name: framework
 * Proyect name: DivideAndConquer
 */
package mergesort;

import java.util.ArrayList;

import framework.Problem;
import framework.Solution;

public class MergeSortDescription implements Problem, Solution{
	/** 
	 * Atributes
	 */
	private ArrayList<Integer> vector;
	private int counter;
	/**
	 * Constructor: MergeSortDescription
	 */
	public MergeSortDescription(ArrayList<Integer> vector) {
		resetMergeSort(vector);
	}
	/**
	 * resetMergeSort
	 */
	public void resetMergeSort(ArrayList<Integer> vector) {
		setCounter(0);
		setVector(vector);
	}
	/**
	 * getProblemSize
	 */
	public int getProblemSize() {
		return vector.size();
	}
	/**
	 * decomposeProblem
	 */
	public ArrayList<Problem> decomposeProblem(){
		ArrayList<Problem> decomposedProblem = new ArrayList<>();
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for (int i = 0; i < vector.size()/2; i++) {
			left.add(vector.get(i));
		}
		for (int i = vector.size()/2; i < vector.size(); i++) {
			right.add(vector.get(i));
		}
		decomposedProblem.add(new MergeSortDescription(left));
		decomposedProblem.add(new MergeSortDescription(right));
		return decomposedProblem;
	}
	/**
	 * showVector
	 */
	public String vectorToString() {
		return vector.toString();
	}
	/**
	 * first
	 */
	public int getFirstElement() {
		return vector.get(0);
	}
	/**
	 * getElement
	 */
	public int getElement(int position) {
		return vector.get(position);
	}
	/**
	 * deleteFirstElement
	 */
	public void deleteFirstElement() {
		vector.remove(0);
	}
	/**
	 * @param vector the vector to set
	 */
	public void setVector(ArrayList<Integer> vector) {
		this.vector = vector;
	}
	/**
	 * @return the counter
	 */
	public int getCounter() {
		int aux = counter;
		return aux;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	/**
	 * incrementCounter
	 */
	public void incrementCounter() {
		counter++;
	}
}
