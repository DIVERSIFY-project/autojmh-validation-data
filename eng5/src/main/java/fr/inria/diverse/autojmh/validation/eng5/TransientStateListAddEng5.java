package fr.inria.diverse.autojmh.validation.eng5;

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
public class TransientStateListAddEng5 {

    ArrayList<Integer> a;
    int value;
    @Setup(Level.Invocation)
    public void set(){
        a = new ArrayList<Integer>();
        a.add(1);
        a.add(100);
        a.add(8);
        value = 3;
    }

    @Benchmark
    public void doBenchmark3(Blackhole bh ) {
        a.add(value);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListAddEng5.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}

