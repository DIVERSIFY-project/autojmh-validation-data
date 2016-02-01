package fr.inria.diverse.autojmh.validation.eng5;

import fr.inria.benchexp.samples.FunA;
import fr.inria.benchexp.samples.MyFunction;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 *  ---- Microbenchmark 1 -----
 *
 * This microbenchmark serves to demonstrate the somehow self-evident
 * but frequently ignored fact the performance of one segment of code
 * not only depends on the value of the variables, but also
 * on their types.
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DifferentInheritorsEng5 {

    double y;
    double angle;
    double sinSum;

    @Setup(Level.Invocation)
    public void set1(){
        sinSum = 0;
        y = angle;
        angle = angle + sinSum * 0.0000001;
    }

    @Benchmark
    public double baselineValidated() {
        return 0.0;
    }

    MyFunction c;
    @Benchmark
    public void doBenchmark(Blackhole bh ) {
        double sinSum = 0;
        if (c == null) c = new FunA();
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng5.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

