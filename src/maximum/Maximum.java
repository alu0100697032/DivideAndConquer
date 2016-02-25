/**
 * File name:Maximum.java
 * Package name: framework
 * Proyect name: DivideAndConquer
 */
package maximum;

import java.util.ArrayList;

import framework.Framework;
import framework.Problem;
import framework.Solution;

public class Maximum extends Framework{

	/* (non-Javadoc)
	 * @see framework.Framework#isSimple(framework.Problem)
	 */
	@Override
	protected boolean isSimple(Problem problem) {
		// TODO Auto-generated method stub
		return (((MaximumDescription)problem).getProblemSize() <= 1);
	}

	/* (non-Javadoc)
	 * @see framework.Framework#simplySolve(framework.Problem)
	 */
	@Override
	protected Solution simplySolve(Problem problem) {
		// TODO Auto-generated method stub
		((MaximumDescription)problem).setMaximum(((MaximumDescription)problem).first());
		return (Solution) problem;
	}

	/* (non-Javadoc)
	 * @see framework.Framework#decompose(framework.Problem)
	 */
	@Override
	protected ArrayList<Problem> decompose(Problem problem) {
		// TODO Auto-generated method stub
		ArrayList<Problem> problems = new ArrayList<>();
		problems = ((MaximumDescription)problem).decomposeProblem();
		return problems;
	}

	/* (non-Javadoc)
	 * @see framework.Framework#combine(framework.Problem, java.util.ArrayList)
	 */
	@Override
	protected Solution combine(Problem problem, ArrayList<Solution> solutions) {
		// TODO Auto-generated method stub
		MaximumDescription left = ((MaximumDescription)solutions.get(0));
		MaximumDescription right = ((MaximumDescription)solutions.get(1));
			if(left.getMaximum() >= right.getMaximum()) {
				((MaximumDescription)problem).setMaximum(left.getMaximum());
			}else {
				((MaximumDescription)problem).setMaximum(right.getMaximum());
			}
		return (Solution)problem;
	}
}
