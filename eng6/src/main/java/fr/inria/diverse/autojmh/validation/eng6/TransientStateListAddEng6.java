package fr.inria.diverse.autojmh.validation.eng6;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * ---- Microbenchmark 3 -----
 *
 * Microbenchmark to measure the time it takes to measure one a call to .add()
 * just after the creation of the list
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class TransientStateListAddEng6 {

    ArrayList<Integer> a = new ArrayList<Integer>(10);
    int value;

    @Benchmark
    @OperationsPerInvocation(10)
    public void benchAdd() {
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.add(value);
        a.clear();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListAddEng6.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}

