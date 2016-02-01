package fr.inria.diverse.autojmh.validation.eng1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/**
 * ---- Microbenchmark 4 -----
 *
 * Microbenchmark to measure the time it takes to measure a call to .sort()
 * in an ArrayList with 10 elements
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class TransientStateListSortEng1 {

    ArrayList<Integer> b = new ArrayList<Integer>();

    @Setup(Level.Invocation)
    public void setup(){
        b = new ArrayList<Integer>();
        b.add(7);
        b.add(1);
        b.add(9);
        b.add(6);
        b.add(0);
        b.add(3);
        b.add(2);
        b.add(4);
        b.add(5);
        b.add(8);
    }

    @Benchmark
    public void doBenchmarkEng1(Blackhole bh) {
        b.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListSortEng1.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}

