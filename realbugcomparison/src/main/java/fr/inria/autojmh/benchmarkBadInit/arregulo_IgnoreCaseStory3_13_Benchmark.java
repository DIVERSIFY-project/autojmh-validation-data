
package fr.inria.autojmh.benchmarkBadInit;

import org.openjdk.jmh.annotations.*;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_IgnoreCaseStory3_13_Benchmark {


    public java.util.HashMap<String, Integer> hash;

    public String key;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-IgnoreCaseStory3-13--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_IgnoreCaseStory3_13_s = new Loader();
            arregulo_IgnoreCaseStory3_13_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            hash = arregulo_IgnoreCaseStory3_13_s.readSerializable();
            key = arregulo_IgnoreCaseStory3_13_s.readSerializable();

            arregulo_IgnoreCaseStory3_13_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public Integer doBenchmark() {
    return hash.get(key.toLowerCase());

        
    }
}
