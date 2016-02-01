package fr.inria.diverse.autojmh.validation.eng2;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by marodrig on 25/01/2016.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class TransientStateListAddEng2 {

    int capacity = 10000000;
    int value = 7;
    ArrayList<Integer> a = new ArrayList<Integer>(capacity);

    @Benchmark
    public void benchAdd1Eng2(Blackhole bh) {
        //Put the code to be benchmarked here!
        if (a.size() < capacity) a.add(value);
        else a.clear();
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
