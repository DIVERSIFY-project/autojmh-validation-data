
package fr.inria.autojmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_CollectionToListStory6_33_Benchmark {


    public java.util.ArrayList<java.lang.Integer> result;

    public java.util.Collection<java.lang.Integer> _data;

    public java.lang.Integer o;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-CollectionToListStory6-33--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_CollectionToListStory6_33_s = new Loader();
            arregulo_CollectionToListStory6_33_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            _data = arregulo_CollectionToListStory6_33_s.readIntegerCollection();

            arregulo_CollectionToListStory6_33_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public ArrayList<Integer> doBenchmark() {
        ArrayList<Integer> result = new java.util.ArrayList<java.lang.Integer>(_data.size());
        for (java.lang.Integer o : _data) {
            result.add(o);
        }
        return result;
    }
}
