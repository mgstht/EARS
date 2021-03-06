package org.um.feri.ears.problems.unconstrained.cec2010;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.RandomMatrices;
import org.um.feri.ears.problems.unconstrained.cec.Functions;
import org.um.feri.ears.util.Util;

public class F17 extends CEC2010{
	
	public F17(int d) {
		super(d, 17);
		
		name = "F17 D/m-group Shifted and m-dimensional Schwefel's Problem 1.2";
		
		P = new int[numberOfDimensions];
		P = Util.randomPermutation(numberOfDimensions);
		OShift = new double[numberOfDimensions];

		for (int i=0; i<numberOfDimensions; i++){
			OShift[i] = Util.nextDouble(lowerLimit.get(i),upperLimit.get(i));
		}
		
		M = new double[m*m];
		
		DenseMatrix64F A = RandomMatrices.createOrthogonal(m, m, Util.rnd);
		
		for (int i=0; i<m; i++){
			for (int j=0; j<m; j++){
				M[i * m + j] = A.get(i, j);
			}
		}
	}

	@Override
	public double eval(Double[] ds) {
		return eval(ArrayUtils.toPrimitive(ds));
	}
	
	public double eval(double x[]) {
		double F = 0;
		int max = (numberOfDimensions / (m << 1));
		int from, to;
		
		double[] p1;
		double[] s1;

		for (int k = 0; k < max; k++) {
			from = k*m;
			to = (k+1)*m - 1;
			p1 = getPermutatedIndices(x,P,from,to-from);
			s1 = getPermutatedIndices(OShift,P,from,to-from);
			F += Functions.schwefel_func(p1, to-from, s1, M, 1, 0);
		}

		return F;
	}

}
