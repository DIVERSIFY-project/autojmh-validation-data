package fr.inria.diverse.autojmh.validation.eng3;

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
public class MathOperationsEng3 {

    private static final double PI = Math.PI * 3;

    private Random random;

    @Setup(Level.Trial)
    public void setup() {
        random = new Random();
    }

    @Benchmark
    public void benchEquationEng3(Blackhole bh) {
        double angle = random.nextDouble();
        double y = angle;
        angle += Math.abs(Math.sin(y)) / PI;
        bh.consume(angle);
    }

    @Benchmark
    public void benchSimpleMultiplicationEng3(Blackhole bh) {
        double x = random.nextDouble();
        double y = random.nextDouble();
        x = Math.abs(x) < 0.0000001 ? 1.00 : x;
        y = Math.abs(y) < 0.0000001 ? 1.00 : y;
        double c = x * y;
        bh.consume(c);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MathOperationsEng3.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

