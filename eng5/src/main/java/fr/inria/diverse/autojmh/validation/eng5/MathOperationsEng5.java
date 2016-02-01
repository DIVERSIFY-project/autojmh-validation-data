package fr.inria.diverse.autojmh.validation.eng5;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
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
public class MathOperationsEng5 {

    double y;
    double x;
    double angle;
    double sinSum;
    @Setup(Level.Invocation)
    public void set1(){
        sinSum = 0;
        y = angle;
        x = y;
        angle = angle + sinSum * 0.0000001;
    }

    @Benchmark
    public double benchSimpleMultiplicationEng5() {
        return x * y;
    }

    @Benchmark
    public void benchEquationEng5(Blackhole bh ) {
        angle += Math.abs(Math.sin(y)) / Math.PI * 3;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MathOperationsEng5.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

