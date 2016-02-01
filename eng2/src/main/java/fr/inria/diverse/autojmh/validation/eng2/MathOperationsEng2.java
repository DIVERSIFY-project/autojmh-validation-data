package fr.inria.diverse.autojmh.validation.eng2;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by marodrig on 25/01/2016.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MathOperationsEng2 {

    double angle = 0;

    double x = 200000;
    double y = 3000000;
    double xt = Math.abs(x) < 0.0000001 ? 1.00 : x;
    double yt = Math.abs(y) < 0.0000001 ? 1.00 : y;

    private static double PI = Math.PI * 3;
    private static double SIN_PI = Math.sin(PI);

    @Benchmark
    public double baselineMathOpEng2() {
        return 0.0;
    }

    @Benchmark
    public void benchEquationEng2(Blackhole bh) {
        angle += angle < SIN_PI ? angle * 0.0000001 + Math.abs(Math.sin(angle)) / PI : -angle;
    }

    @Benchmark
    public void benchSimpleMultEng2(Blackhole bh) {
        double c = xt * yt;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MathOperationsEng2.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
