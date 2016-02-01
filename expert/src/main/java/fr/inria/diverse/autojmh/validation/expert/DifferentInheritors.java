package fr.inria.diverse.autojmh.validation.expert;

import fr.inria.benchexp.samples.FunA;
import fr.inria.benchexp.samples.FunB;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 *  ---- Microbenchmark 1 -----
 *
 * This microbenchmark serves to demonstrate the somehow self-evident
 * but frequently ignored fact the performance of one segment of code
 * not only depends on the value of the variables, but also
 * on their types.
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DifferentInheritors {

    private double sinSum;

    //@Benchmark
    public double baselineValidated() {
        return 0.0;
    }

    /**
     * Please note that here we want to evaluate the performance of a "for" loop
     * performing 100 iterations and accumulating the result of the c.calc method.
     *
     * We *don't* want to estimate the performance of the c.calc method.
     */
    @Benchmark
    public double benchFunAArray100Validated() {
        FunA c = new FunA();
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
        return sinSum;
    }

    /**
     * Please note that here we want to evaluate the performance of a "for" loop
     * performing 100 iterations and accumulating the result of the c.calc method.
     *
     * We *don't* want to estimate the performance of the c.calc method.
     */
    @Benchmark
    public double benchFunBArray100Validated() {
        FunB c = new FunB();
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
        return sinSum;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritors.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

