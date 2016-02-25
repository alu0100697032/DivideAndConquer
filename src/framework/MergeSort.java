/**
 * File name:MergeSort.java
 * Package name: framework
 * Proyect name: DivideAndConquer
 */
package framework;

import java.util.ArrayList;

public class MergeSort extends Framework{
	/**
	 * Constructor: MergeSort
	 */
	public MergeSort() {
		
	}
	/* (non-Javadoc)
	 * @see framework.Framework#isSimple(framework.Problem)
	 */
	@Override
	protected boolean isSimple(Problem problem) {
		// TODO Auto-generated method stub)
		return (	((MergeSortDescription)problem).getProblemSize() <= 1);
	}

	/* (non-Javadoc)
	 * @see framework.Framework#simplySolve(framework.Problem)
	 */
	@Override
	protected Solution simplySolve(Problem problem) {
		// TODO Auto-generated method stub
		return (Solution) problem;
	}

	/* (non-Javadoc)
	 * @see framework.Framework#decompose(framework.Problem)
	 */
	@Override
	protected ArrayList<Problem> decompose(Problem problem) {
		// TODO Auto-generated method stub
		ArrayList<Problem> problems = new ArrayList<>();
		problems = ((MergeSortDescription)problem).decomposeProblem();
		return problems;
	}

	/* (non-Javadoc)
	 * @see framework.Framework#combine(framework.Problem, java.util.ArrayList)
	 */
	@Override
	protected Solution combine(Problem problem, ArrayList<Solution> solutions) {
		// TODO Auto-generated method stub
		ArrayList<Integer> combinedSolutions = new ArrayList<>();
		MergeSortDescription left = ((MergeSortDescription)solutions.get(0));
		MergeSortDescription right = ((MergeSortDescription)solutions.get(1));
		while(left.getProblemSize() > 0 && right.getProblemSize() > 0) {
			if(left.getFirstElement() <= right.getFirstElement()) {
				combinedSolutions.add(left.getFirstElement());
				left.deleteFirstElement();
			}else {
				combinedSolutions.add(right.getFirstElement());
				right.deleteFirstElement();
			}
		}
		if(left.getProblemSize() > 0) {
			for(int i = 0; i < left.getProblemSize(); i++) 
				combinedSolutions.add(left.getElement(i));
		}
		if(right.getProblemSize() > 0) {
			for(int i = 0; i < right.getProblemSize(); i++) 
				combinedSolutions.add(right.getElement(i));
		}
		((MergeSortDescription)problem).setVector(combinedSolutions);
		return (Solution)problem;
	}
}
