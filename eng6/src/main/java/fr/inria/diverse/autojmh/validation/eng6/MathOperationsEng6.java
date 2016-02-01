package fr.inria.diverse.autojmh.validation.eng6;

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
public class MathOperationsEng6 {


    double x,y;
    @Benchmark
    @OperationsPerInvocation(1)
    public void benchSimpleMult(MathOperationsEng6 b) {
        double c = b.x*b.y;
    }

    double acum = 0;
    private static double PI = Math.PI * 3;

    @Benchmark
    @OperationsPerInvocation(4)
    public void benchEquation() {
        acum += Math.abs(Math.sin(1)) / PI;
        acum += Math.abs(Math.sin(-1)) / PI;
        acum += Math.abs(Math.sin(1)) / PI;
        acum += Math.abs(Math.sin(-1)) / PI;
        acum=0;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MathOperationsEng6.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

