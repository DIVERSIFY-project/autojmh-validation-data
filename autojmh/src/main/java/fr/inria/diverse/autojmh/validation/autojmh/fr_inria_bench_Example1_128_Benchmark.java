
package fr.inria.diverse.autojmh.validation.autojmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class fr_inria_bench_Example1_128_Benchmark {

    static final String DATA_ROOT_FOLDER = Main.DATA_ROOT_FOLDER;
    static final String DATA_FILE = "fr-inria-bench-Example1-107--main-sun.misc.Launcher$AppClassLoader@106d69c";

    public double x;
    public double y;

    @Setup(Level.Trial)
    public void setup() {
        try {
            Loader fr_inria_bench_Example1_128_s = new Loader();
            fr_inria_bench_Example1_128_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            x = fr_inria_bench_Example1_128_s.readdouble();
            y = fr_inria_bench_Example1_128_s.readdouble();

            fr_inria_bench_Example1_128_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public double doBenchmark() {
        double c = x * y;
        return c;
    }
}
