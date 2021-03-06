package org.um.feri.ears.problems.moo.unconstrained.cec2009;

import java.util.ArrayList;

import org.um.feri.ears.problems.moo.DoubleMOProblem;
import org.um.feri.ears.problems.moo.MOSolutionBase;
import org.um.feri.ears.problems.moo.functions.UP8_F6_1;
import org.um.feri.ears.problems.moo.functions.UP8_F6_2;
import org.um.feri.ears.problems.moo.functions.UP8_F6_3;


public class UnconstrainedProblem8 extends CEC2009 {

	/**
	 * Constructor. Creates a default instance of problem CEC2009_UnconstrainedProblem8 (30 decision variables)
	 */
	public UnconstrainedProblem8() {
		this(30); // 30 variables by default
	}

	/**
	 * Creates a new instance of problem CEC2009_UnconstrainedProblem8.
	 * @param numberOfVariables Number of variables.
	 */
	public UnconstrainedProblem8(Integer numberOfVariables) {
		super(numberOfVariables,0, 3);

		name = "UF8";
		file_name = "UF8";
		
		upperLimit = new ArrayList<Double>(numberOfDimensions);
		lowerLimit = new ArrayList<Double>(numberOfDimensions);
		
		lowerLimit.add(0.0);
		upperLimit.add(1.0);
		lowerLimit.add(0.0);
		upperLimit.add(1.0);

		for (int var = 2; var < numberOfVariables; var++) {
			lowerLimit.add(-2.0);
			upperLimit.add(2.0);
		}

		this.addObjective(new UP8_F6_1(numberOfDimensions));
		this.addObjective(new UP8_F6_2(numberOfDimensions));
		this.addObjective(new UP8_F6_3(numberOfDimensions));

	}

	@Override
	public void evaluateConstraints(MOSolutionBase<Double> solution) {
	}
}
