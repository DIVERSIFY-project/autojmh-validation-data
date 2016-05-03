
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_CollectionToListStory6_16_Benchmark {


    public java.util.Collection<Integer> _data;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-CollectionToListStory6-16--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_CollectionToListStory6_16_s = new Loader();
            arregulo_CollectionToListStory6_16_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            _data = arregulo_CollectionToListStory6_16_s.readIntegerCollection();

            arregulo_CollectionToListStory6_16_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        ArrayList<Integer> a = new java.util.ArrayList<>(_data);
    }
}
