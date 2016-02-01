
package fr.inria.diverse.autojmh.validation.autojmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class fr_inria_bench_Example1_107_Benchmark {

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/PROJECTS/benchsource_work/log";
    static final String DATA_FILE = "fr-inria-bench-Example1-107--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    public double angle;
    public double y;
    public double fr_inria_bench_Example1_PI;

    @Setup(Level.Trial)
    public void setup() {
        try {
            Loader fr_inria_bench_Example1_107_s = new Loader();
            fr_inria_bench_Example1_107_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            angle = fr_inria_bench_Example1_107_s.readdouble();
            y = fr_inria_bench_Example1_107_s.readdouble();
            fr_inria_bench_Example1_PI = fr_inria_bench_Example1_107_s.readdouble();

            fr_inria_bench_Example1_107_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        angle += (java.lang.Math.abs(java.lang.Math.sin(y))) / fr_inria_bench_Example1_PI
        ;


    }
}
