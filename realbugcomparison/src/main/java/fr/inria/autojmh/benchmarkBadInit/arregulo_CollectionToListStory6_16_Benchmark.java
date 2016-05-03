
package fr.inria.autojmh.benchmarkBadInit;

import org.openjdk.jmh.annotations.*;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_CollectionToListStory6_16_Benchmark {


    public java.util.Collection<Integer> _data;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-CollectionToListStory6-16--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_CollectionToListStory6_16_s = new Loader();
            arregulo_CollectionToListStory6_16_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            _data = arregulo_CollectionToListStory6_16_s.readIntegerCollection();

            arregulo_CollectionToListStory6_16_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public java.util.ArrayList doBenchmark() {
    return new java.util.ArrayList<Integer>(_data);

        
    }
}
