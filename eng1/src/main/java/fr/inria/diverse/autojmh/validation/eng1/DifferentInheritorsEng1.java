package fr.inria.diverse.autojmh.validation.eng1;

import fr.inria.benchexp.samples.FunA;
import fr.inria.benchexp.samples.MyFunction;
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
public class DifferentInheritorsEng1 {

    double sinSum = 0;
    MyFunction c = new FunA();

    @Benchmark
    public void benchFunAArray100Eng1(Blackhole bh) {
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng1.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
