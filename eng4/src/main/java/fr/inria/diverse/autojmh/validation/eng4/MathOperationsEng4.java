package fr.inria.diverse.autojmh.validation.eng4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
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
public class MathOperationsEng4 {

    private static double PI = Math.PI * 3;

    @Benchmark
    public void benchMultiplicationEng4(Blackhole bh) {
        final Random random = new Random();
        double c = ((random.nextDouble()-0.5d)*Double.MAX_VALUE) * ((random.nextDouble()-0.5d)*Double.MAX_VALUE);
    }

    @Benchmark
    public void benchEquationEng4(Blackhole bh) {
        final Random random = new Random();
        double angle = random.nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2; // initializing the angle.
        angle += Math.abs(Math.sin((new Random().nextDouble()-0.5d)*Math.PI*2d)) / PI;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MathOperationsEng4.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
/*
    @Benchmark
    public double benchSimpleMultiplicationValidated() {
        return x * y;
    }

    @Benchmark
    public double benchEquationValidated() {
        angle += Math.abs(Math.sin(y)) / Math.PI;
        return angle;
    }
*/

