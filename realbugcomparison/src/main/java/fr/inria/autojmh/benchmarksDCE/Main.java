
package fr.inria.autojmh.benchmarksDCE;

import fr.inria.autojmh.humanmade.arregulo.reflection.CreateNewInstance;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;

public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(arregulo_CreateNewInstanceStory5_26_Benchmark.class.getSimpleName())
                .include(CreateNewInstance.class.getSimpleName())
                /*
                .include(oraclebugs_StringFormat8050142_17_Benchmark.class.getSimpleName())
                .include(oraclebugs_StringFormat8050142_13_Benchmark.class.getSimpleName())
                .include(arregulo_CollectionToListStory6_33_Benchmark.class.getSimpleName())
                .include(oraclebugs_StringFormat8050142_33_Benchmark.class.getSimpleName())
                .include(oraclebugs_PatternMatcher8151481_15_Benchmark.class.getSimpleName())
                .include(arregulo_CreateNewInstanceStory5_26_Benchmark.class.getSimpleName())
                .include(arregulo_IgnoreCaseStory3_18_Benchmark.class.getSimpleName())
                .include(arregulo_LongKeyMapStory2_18_Benchmark.class.getSimpleName())
                .include(oraclebugs_StringFormat8050142_21_Benchmark.class.getSimpleName())
                .include(arregulo_IgnoreCaseStory3_13_Benchmark.class.getSimpleName())
                .include(arregulo_IgnoreCaseStory3_24_Benchmark.class.getSimpleName())
                .include(arregulo_CreateNewInstanceStory5_15_Benchmark.class.getSimpleName())
                .include(oraclebugs_ForStream8146071_25_Benchmark.class.getSimpleName())
                .include(arregulo_GetFieldsStory4_15_Benchmark.class.getSimpleName())
                .include(oraclebugs_StringFormat8050142_29_Benchmark.class.getSimpleName())
                .include(arregulo_CollectionToListStory6_16_Benchmark.class.getSimpleName())
                .include(arregulo_LongKeyMapStory2_13_Benchmark.class.getSimpleName())
                .include(oraclebugs_StringFormat8050142_25_Benchmark.class.getSimpleName())
                .include(arregulo_CreateNewInstanceStory5_41_Benchmark.class.getSimpleName())
                .include(oraclebugs_ForStream8146071_13_Benchmark.class.getSimpleName())/**/
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .shouldFailOnError(true)
                .build();

        Collection<RunResult> results = new Runner(opt).run();
    }
}
