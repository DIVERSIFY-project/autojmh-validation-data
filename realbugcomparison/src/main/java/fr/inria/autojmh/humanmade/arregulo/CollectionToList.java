package fr.inria.autojmh.humanmade.arregulo;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class CollectionToList {
    @Param({"ArrayList", "HashSet"})
    private String collection;

    private Collection<Integer> data;

    @Setup
    public void setUp() throws Exception {
        data = (Collection<Integer>) Class.forName("java.util." + collection).newInstance();
        for (int i = 0; i < 10_000; i++) {
            data.add(i);
        }
    }
/*
    @Benchmark
    public ArrayList<Integer> new_ArrayList_from_Collection() {
        return new ArrayList<>(data);
    }

    @Benchmark
    public ArrayList<Object> new_ArrayList_addAll() {
        ArrayList<Object> result = new ArrayList<>(data.size());
        result.addAll(data);
        return result;
    }
*/
    @Benchmark
    public ArrayList<Integer> new_ArrayList_add() {
        ArrayList<Integer> result = new ArrayList<>(data.size());
        for (Integer o : data) {
            result.add(o);
        }
        return result;
    }
}
