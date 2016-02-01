
package fr.inria.diverse.autojmh.validation.autojmh;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class fr_inria_bench_Example1_51_Benchmark {

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/PROJECTS/benchsource_work/log";
    static final String DATA_FILE = "fr-inria-bench-Example1-51--main-sun.misc.Launcher$AppClassLoader@106d69c";

    public ArrayList<Integer> a;
    public int value;

    @Setup(Level.Trial)
    public void setup() {
        try {
            Loader fr_inria_bench_Example1_51_s = new Loader();
            fr_inria_bench_Example1_51_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);
            a = fr_inria_bench_Example1_51_s.readIntegerArrayList();
            value = fr_inria_bench_Example1_51_s.readint();
            fr_inria_bench_Example1_51_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Setup(Level.Invocation)
    public void setupIteration() {
        a.clear();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
    }

    @Benchmark
    public void doBenchmark() {
        a.add(value);
    }
}
