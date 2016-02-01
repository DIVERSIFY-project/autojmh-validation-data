package fr.inria.diverse.autojmh.validation.expert;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * ---- Microbenchmark 2 -----
 *
 * Very simple microbenchmarks avoiding DCE and constant folding.
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MathOperations {

    private double y = Math.PI / 4;
    private double angle = 0.0;
    private double x = Math.PI;

    @Benchmark
    public double benchSimpleMultiplicationValidated() {
        return x * y;
    }

    @Benchmark
    public void benchEquationValidated() {
        angle += Math.abs(Math.sin(y)) / Math.PI;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MathOperations.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

