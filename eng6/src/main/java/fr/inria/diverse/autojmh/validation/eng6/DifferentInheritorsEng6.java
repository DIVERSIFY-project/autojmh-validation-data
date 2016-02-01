package fr.inria.diverse.autojmh.validation.eng6;

import fr.inria.benchexp.samples.FunA;
import fr.inria.benchexp.samples.FunB;
import fr.inria.benchexp.samples.MyFunction;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
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
public class DifferentInheritorsEng6 {

    double sinSum = 0;
    Random r = new Random();
    FunB c = new FunB();// 50% times the variable is passed

    @Benchmark
    public void doFunB() {
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng6.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

