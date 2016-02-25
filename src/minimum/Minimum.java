/**
 * File name:Minimum.java
 * Package name: minimum
 * Proyect name: DivideAndConquer
 */
package minimum;

import java.util.ArrayList;

import framework.Framework;
import framework.Problem;
import framework.Solution;

public class Minimum extends Framework{

	/* (non-Javadoc)
	 * @see framework.Framework#isSimple(framework.Problem)
	 */
	@Override
	protected boolean isSimple(Problem problem) {
		// TODO Auto-generated method stub
		return (((MinimumDescription)problem).getProblemSize() <= 1);
	}

	/* (non-Javadoc)
	 * @see framework.Framework#simplySolve(framework.Problem)
	 */
	@Override
	protected Solution simplySolve(Problem problem) {
		// TODO Auto-generated method stub
		((MinimumDescription)problem).setMinimum(((MinimumDescription)problem).first());
		return (Solution) problem;
	}

	/* (non-Javadoc)
	 * @see framework.Framework#decompose(framework.Problem)
	 */
	@Override
	protected ArrayList<Problem> decompose(Problem problem) {
		// TODO Auto-generated method stub
		ArrayList<Problem> problems = new ArrayList<>();
		problems = ((MinimumDescription)problem).decomposeProblem();
		return problems;
	}

	/* (non-Javadoc)
	 * @see framework.Framework#combine(framework.Problem, java.util.ArrayList)
	 */
	@Override
	protected Solution combine(Problem problem, ArrayList<Solution> solutions) {
		// TODO Auto-generated method stub
		MinimumDescription left = ((MinimumDescription)solutions.get(0));
		MinimumDescription right = ((MinimumDescription)solutions.get(1));
			if(left.getMinimum() <= right.getMinimum()) {
				((MinimumDescription)problem).setMinimum(left.getMinimum());
			}else {
				((MinimumDescription)problem).setMinimum(right.getMinimum());
			}
		return (Solution)problem;
	}
}
