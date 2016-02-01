package fr.inria.diverse.autojmh.validation.eng6;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by marodrig on 26/01/2016.
 */
public class MainEng6 {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng6.class.getSimpleName())
                .include(MathOperationsEng6.class.getSimpleName())
                .include(TransientStateListAddEng6.class.getSimpleName())
                .include(TransientStateListSortEng6.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
