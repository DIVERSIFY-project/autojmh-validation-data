package fr.inria.autojmh.humanmade.arregulo.map;

import fr.inria.autojmh.benchmarks.Loader;
import org.openjdk.jmh.annotations.*;
import water.nbhm.NonBlockingHashMapLong;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class LongKeyMap {
    //private ConcurrentHashMap<Long, Double> chm;
    private NonBlockingHashMapLong<Double> nbhm1;
    private NonBlockingHashMapLong<Double> nbhm;
    private long key;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-LongKeyMapStory2-18--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_LongKeyMapStory2_18_s = new Loader();
            arregulo_LongKeyMapStory2_18_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            nbhm1 = arregulo_LongKeyMapStory2_18_s.readSerializable();
            key = arregulo_LongKeyMapStory2_18_s.readlong();

            nbhm = new NonBlockingHashMapLong<>();
            for ( Map.Entry<Long, Double> k : nbhm1.entrySet()) {
                nbhm.put(k.getKey(), k.getValue());
            }

            arregulo_LongKeyMapStory2_18_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    @Setup
    public void setUp() {
        chm = new ConcurrentHashMap<>();
        nbhm = new NonBlockingHashMapLong<>();
        long[] data = generate(50_000);
        populate(chm, data);
        populate(nbhm, data);
        for (Double d : nbhm.values())
            System.err.println(d);
        key = 6528321900546851391L;
    }

    private void populate(Map<Long, Double> map, long[] data) {
        for (long key : data) {
            map.put(key, Double.longBitsToDouble(key));
        }
        if (map.size() != data.length) {
            throw new AssertionError();
        }
    }

    private long[] generate(int size) {
        Random r = new Random(-7890);
        long[] result = new long[size];
        for (int i = 0; i < size; i++) {
            result[i] = Math.abs(r.nextLong());
        }
        for (Double d : nbhm.values())
            System.err.println(d);
        return result;
    }
/*
    @Benchmark
    public Double get_ConcurrentHashMap() {
        return chm.get(key);
    }
*/
    @Benchmark
    public Double get_NonBlockingHashMapLong() {
        return nbhm.get(key);
    }
}
