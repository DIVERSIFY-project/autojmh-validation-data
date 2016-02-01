package fr.inria.diverse.autojmh.validation.eng4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
public class TransientStateListAddEng4 {

    @Benchmark
    public ArrayList<Integer> baselineEng4() {
        return new ArrayList<Integer>();
    }

    @Benchmark
    @OperationsPerInvocation(10)
    public void benchAddEng4(Blackhole bh) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0, lgth=10; i<lgth; i++) {
            list.add(new Random().nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListAddEng4.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}

