package fr.inria.benchexp.samples;

/**
 * Created by marodrig on 04/12/2015.
 */
public class FunA implements MyFunction {

    public double calc(double x) {
        return Math.log(2 * x + 2 * x);
    }

}
