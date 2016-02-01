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
public class DifferentInheritorsEng2 {

    double sinSum = 0;

    @Benchmark
    public void benchFunAArray100Eng2(Blackhole bh) {
        for (int i = 0; i < 100; i++) {
            //sinSum += c.calc(i);
            sinSum += i + i;
        }
    }

    @Benchmark
    public void benchFunBArray100Eng2(Blackhole bh) {
        for (int i = 0; i < 100; i++) {
            //sinSum += c.calc(i);
            sinSum += Math.log(2 * i + 2 * i);
            bh.consume(sinSum);
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListAddEng2.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
