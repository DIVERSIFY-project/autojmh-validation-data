
package fr.inria.autojmh.benchmarks;

import org.openjdk.jmh.annotations.*;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_LongKeyMapStory2_13_Benchmark {


    public java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.lang.Double> chm;

    public long key;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-LongKeyMapStory2-13--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_LongKeyMapStory2_13_s = new Loader();
            arregulo_LongKeyMapStory2_13_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            chm = arregulo_LongKeyMapStory2_13_s.readSerializable();
            key = arregulo_LongKeyMapStory2_13_s.readlong();

            arregulo_LongKeyMapStory2_13_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public java.lang.Double doBenchmark() {
    return chm.get(key);

        
    }
}
