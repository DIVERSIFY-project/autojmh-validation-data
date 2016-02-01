package fr.inria.diverse.autojmh.validation.eng1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * Created by marodrig on 25/01/2016.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MathOperationsEng1 {

    double angle = 0;

    double x = 200000;
    double y = 3000000;
    double xt = Math.abs(x) < 0.0000001 ? 1.00 : x;
    double yt = Math.abs(y) < 0.0000001 ? 1.00 : y;

    private static double PI = Math.PI * 3;
    private static double SIN_PI = Math.sin(PI);

    @Benchmark
    public double baselineMathOpEng1() {
        return 0.0;
    }

    @Benchmark
    public void benchEquationEng1(Blackhole bh) {
        angle += angle < SIN_PI ? angle * 0.0000001 + Math.abs(Math.sin(angle)) / PI : -angle;
    }

    @Benchmark
    public void benchSimpleMultEng1(Blackhole bh) {
        double c = xt * yt;
    }

}
