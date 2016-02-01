package fr.inria.diverse.autojmh.validation.eng1;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by marodrig on 26/01/2016.
 */
public class MainEng1 {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng1.class.getSimpleName())
                .include(MathOperationsEng1.class.getSimpleName())
                .include(TransientStateListAddEng1.class.getSimpleName())
                .include(TransientStateListSortEng1.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
