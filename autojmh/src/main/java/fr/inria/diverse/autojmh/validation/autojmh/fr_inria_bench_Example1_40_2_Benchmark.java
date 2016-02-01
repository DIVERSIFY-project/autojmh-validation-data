
package fr.inria.diverse.autojmh.validation.autojmh;

import fr.inria.bench.FunB;
import fr.inria.bench.MyFunction;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class fr_inria_bench_Example1_40_2_Benchmark {

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/PROJECTS/benchsource_work/log";
    static final String DATA_FILE = "fr-inria-bench-Example1-40-2--main-sun.misc.Launcher$AppClassLoader@106d69c";

    public double sinSum;
    public MyFunction c;

    @Setup(Level.Trial)
    public void setup() {
        try {
            Loader fr_inria_bench_Example1_40_s = new Loader();
            fr_inria_bench_Example1_40_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            sinSum = fr_inria_bench_Example1_40_s.readdouble();
            c = (FunB) fr_inria_bench_Example1_40_s.readSerializable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        for (int i = 0 ; i < 100 ; i++) {
            sinSum += c.calc(i);
        }
    }
}
