package fr.inria.diverse.autojmh.validation.expert;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by marodrig on 26/01/2016.
 */
public class MainExpert {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritors.class.getSimpleName())
                .include(MathOperations.class.getSimpleName())
                .include(TransientStateListAdd.class.getSimpleName())
                .include(TransientStateListSort.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
