package fr.inria.diverse.autojmh.validation.eng4;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by marodrig on 26/01/2016.
 */
public class MainEng4 {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng4.class.getSimpleName())
                .include(MathOperationsEng4.class.getSimpleName())
                .include(TransientStateListAddEng4.class.getSimpleName())
                .include(TransientStateListSortEng4.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
