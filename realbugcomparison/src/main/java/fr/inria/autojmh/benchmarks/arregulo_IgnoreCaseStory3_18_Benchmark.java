
package fr.inria.autojmh.benchmarks;

import org.openjdk.jmh.annotations.*;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_IgnoreCaseStory3_18_Benchmark {


    public java.util.TreeMap<java.lang.String, java.lang.Integer> tree;

    public java.lang.String key;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-IgnoreCaseStory3-18--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup////(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_IgnoreCaseStory3_18_s = new Loader();
            arregulo_IgnoreCaseStory3_18_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            tree = arregulo_IgnoreCaseStory3_18_s.readSerializable();
            key = arregulo_IgnoreCaseStory3_18_s.readSerializable();

            arregulo_IgnoreCaseStory3_18_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public java.lang.Integer doBenchmark() {
    return tree.get(key);

        
    }
}
