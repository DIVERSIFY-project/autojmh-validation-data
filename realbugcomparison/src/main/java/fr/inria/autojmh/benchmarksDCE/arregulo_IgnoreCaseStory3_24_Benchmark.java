
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_IgnoreCaseStory3_24_Benchmark {


    public Integer val;

    public java.util.HashMap<String, Integer> ignoreCaseMap;

    public String key;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-IgnoreCaseStory3-24--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_IgnoreCaseStory3_24_s = new Loader();
            arregulo_IgnoreCaseStory3_24_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            ignoreCaseMap = arregulo_IgnoreCaseStory3_24_s.readSerializable();
            key = arregulo_IgnoreCaseStory3_24_s.readSerializable();

            arregulo_IgnoreCaseStory3_24_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        Integer value = ignoreCaseMap.get(key);
        if (value == null) {
            value = ignoreCaseMap.get(key.toLowerCase());
            if (value != null) {
                ignoreCaseMap.put(key, value);
            }
        }
    }
}
