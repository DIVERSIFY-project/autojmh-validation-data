
package fr.inria.diverse.autojmh.validation.autojmh;

import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;

public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()

                .include(fr_inria_bench_Example1_56_Benchmark.class.getSimpleName())
                //.include(fr_inria_bench_Example1_51_Benchmark.class.getSimpleName())
                /*.include(fr_inria_bench_Example1_40_1_Benchmark.class.getSimpleName())
                .include(fr_inria_bench_Example1_40_2_Benchmark.class.getSimpleName())
                .include(fr_inria_bench_Example1_107_Benchmark.class.getSimpleName())
                .include(fr_inria_bench_Example1_128_Benchmark.class.getSimpleName())*/
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .shouldFailOnError(true)
                .build();

        Collection<RunResult> results = new Runner(opt).run();
    }
}
