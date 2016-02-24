/**
 * File name:Framework.java
 * Package name: framework
 * Proyect name: DivideAndConquer
 */
package framework;

import java.util.ArrayList;

abstract public class Framework {
	/**
	 * Constructor: Framework
	 */
	public Framework() {
		
	}
	/**
	 * solve
	 */
	final public Solution solve(Problem problem) {
		ArrayList<Problem> problems = new ArrayList<>();
		if(isSimple(problem))
			return simplySolve(problem);
		else
			problems = decompose(problem);
		ArrayList<Solution> solutions = new ArrayList<>();
		for(int i = 0; i < problems.size(); i++)
			solutions.add(solve(problems.get(i)));
		return combine(problem, solutions);
	}
	/**
	 * isSimple
	 */
	abstract protected boolean isSimple(Problem problem);
	/**
	 * simplySolve
	 */
	abstract protected Solution simplySolve (Problem problem);
	/**
	 * decompose
	 */
	abstract protected ArrayList<Problem> decompose (Problem problem);
	/**
	 * combine
	 */
	abstract protected Solution combine(Problem problem, ArrayList<Solution> solutions);
}
