/**
 * File name:MinimumDescription.java
 * Package name: minimum
 * Proyect name: DivideAndConquer
 */
package minimum;

import java.util.ArrayList;

import framework.Problem;
import framework.Solution;
import maximum.MaximumDescription;

public class MinimumDescription implements Problem, Solution{
	/** 
	 * Atributes
	 */
	private ArrayList<Integer> vector;
	private int minimum;
	/**
	 * Constructor: MinimumDescription
	 */
	public MinimumDescription(ArrayList<Integer> vector) {
		resetMinimum(vector);
	}
	
	/**
	 * getProblemSize
	 */
	public int getProblemSize() {
		return vector.size();
	}
	/**
	 * resetMaximum
	 */
	public void resetMinimum(ArrayList<Integer> vector) {
		setMinimum(Integer.MAX_VALUE);
		setVector(vector);
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
		decomposedProblem.add(new MinimumDescription(left));
		decomposedProblem.add(new MinimumDescription(right));
		return decomposedProblem;
	}
	/**
	 * First
	 */
	public int first() {
		return vector.get(0);
	}
	/**
	 * @param vector the vector to set
	 */
	public void setVector(ArrayList<Integer> vector) {
		this.vector = vector;
	}
	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		int aux = minimum;
		return aux;
	}

	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
