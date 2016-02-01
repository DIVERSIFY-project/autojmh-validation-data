package fr.inria.diverse.autojmh.validation.eng1;

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
public class TransientStateListAddEng1 {

    ArrayList<Integer> a = new ArrayList<Integer>();
    int value = 0;

    @Setup(Level.Invocation)
    public void setup(){
        a = new ArrayList<Integer>();
    }

    @Benchmark
    public void benchAdd1Eng1(Blackhole bh) {
        a.add(value);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListAddEng1.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
