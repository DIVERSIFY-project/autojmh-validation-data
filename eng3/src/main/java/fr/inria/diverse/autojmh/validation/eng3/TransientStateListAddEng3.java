package fr.inria.diverse.autojmh.validation.eng3;

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
public class TransientStateListAddEng3 {

    private List<Integer> a;
    private Random random;

    @Setup(Level.Invocation)
    public void setup() {
        random = new Random();
        a = new ArrayList<Integer>();
        for (int i = 0; i < random.nextInt(); i++) {
            a.add(random.nextInt());
        }
    }

    @Benchmark
    public void benchAddEng3(Blackhole bh) {
        int value = random.nextInt();
        a.add(value);
        bh.consume(a);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListAddEng3.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}

