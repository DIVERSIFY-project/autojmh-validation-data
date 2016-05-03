
package fr.inria.autojmh.benchmarkCF;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_IgnoreCaseStory3_18_Benchmark {


    public java.util.TreeMap<String, Integer> tree;

    public static final String key = "GoodKey";

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-IgnoreCaseStory3-18--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup////(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_IgnoreCaseStory3_18_s = new Loader();
            arregulo_IgnoreCaseStory3_18_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            tree = arregulo_IgnoreCaseStory3_18_s.readSerializable();
            //key = arregulo_IgnoreCaseStory3_18_s.readSerializable();

            arregulo_IgnoreCaseStory3_18_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public Integer doBenchmark() {
    return tree.get(key);

        
    }
}
