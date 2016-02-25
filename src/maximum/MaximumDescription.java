/**
 * File name:MaximumDescription.java
 * Package name: framework
 * Proyect name: DivideAndConquer
 */
package maximum;

import java.util.ArrayList;

import framework.Problem;
import framework.Solution;

public class MaximumDescription implements Problem, Solution{
	/** 
	 * Atributes
	 */
	private ArrayList<Integer> vector;
	private int maximum;
	/**
	 * Constructor: MaximumDescription
	 */
	public MaximumDescription(ArrayList<Integer> vector) {
		resetMaximum(vector);
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
	public void resetMaximum(ArrayList<Integer> vector) {
		setVector(vector);
		setMaximum(0);
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
		decomposedProblem.add(new MaximumDescription(left));
		decomposedProblem.add(new MaximumDescription(right));
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
	 * @return the maximum
	 */
	public int getMaximum() {
		int aux = maximum;
		return aux;
	}

	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
