package fr.inria.autojmh.humanmade.oracle;

/**
 * Created by marodrig on 12/04/2016.
 */

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Random;

@State(Scope.Thread)
public class ForStreamBUG8146071 {

    static final int[] ints = new int[1000000];

    @Setup
    public void setUp() {
        randomInts();
    }

    static void randomInts() {
        Random random = new Random();
        for (int i = 0; i < ints.length; i++)
            ints[i] = random.nextInt();
    }

    @Benchmark
    public int forTest_if() {
        int[] a = ints;
        int e = ints.length;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < e; i++)
            if (a[i] >= m)
                m = a[i];
        return m;
    }

    /*
    @Benchmark
    public int forTest_MathMax() {
        int[] a = ints;
        int e = ints.length;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < e; i++)
            m = Math.max(m, a[i]);
        return m;
    }*/
}