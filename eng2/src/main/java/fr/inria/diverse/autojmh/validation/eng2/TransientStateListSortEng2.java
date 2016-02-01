package fr.inria.diverse.autojmh.validation.eng2;

import org.openjdk.jmh.annotations.*;
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
public class TransientStateListSortEng2 {

    ArrayList<Integer> b = new ArrayList<Integer>() {{
        add(7);
        add(1);
        add(9);
        add(6);
        add(0);
        add(3);
        add(2);
        add(4);
        add(5);
        add(8);
    }};

    @Benchmark
    public void benchSortArrayListEng2() {
        b.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListSortEng2.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}

