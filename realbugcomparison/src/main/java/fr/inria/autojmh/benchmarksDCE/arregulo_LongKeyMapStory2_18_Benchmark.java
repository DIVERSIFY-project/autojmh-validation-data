
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import water.nbhm.NonBlockingHashMapLong;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_LongKeyMapStory2_18_Benchmark {


    public NonBlockingHashMapLong<Double> nbhm;

    public long key;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-LongKeyMapStory2-18--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_LongKeyMapStory2_18_s = new Loader();
            arregulo_LongKeyMapStory2_18_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            nbhm = arregulo_LongKeyMapStory2_18_s.readSerializable();
            key = arregulo_LongKeyMapStory2_18_s.readlong();

            arregulo_LongKeyMapStory2_18_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        Double obj = nbhm.get(key);
    }
}
