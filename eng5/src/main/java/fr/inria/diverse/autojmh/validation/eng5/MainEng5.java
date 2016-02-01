package fr.inria.diverse.autojmh.validation.eng5;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by marodrig on 26/01/2016.
 */
public class MainEng5 {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng5.class.getSimpleName())
                .include(MathOperationsEng5.class.getSimpleName())
                .include(TransientStateListAddEng5.class.getSimpleName())
                .include(TransientStateListSortEng5.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
