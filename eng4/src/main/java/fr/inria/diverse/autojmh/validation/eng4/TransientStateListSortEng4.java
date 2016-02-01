package fr.inria.diverse.autojmh.validation.eng4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * ---- Microbenchmark 4 -----
 *
 * Microbenchmark to measure the time it takes to measure a call to .sort()
 * in an ArrayList with 10 elements
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class TransientStateListSortEng4 {

    final Comparator comp = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };


    @Benchmark
    @OperationsPerInvocation(10)
    public void benchSortArrayListEng4(Blackhole bh) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0, lgth=10; i<lgth; i++) {
            // Not fine since it also benchmarks the add...
            list.add(new Random().nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2);
            list.sort(comp);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListSortEng4.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}


 /*
    @Benchmark
    public void doBenchmarkdefaultMultiplication(Blackhole bh) {
        final Random random = new Random();
        double c = ((random.nextDouble()-0.5d)*Double.MAX_VALUE) * ((random.nextDouble()-0.5d)*Double.MAX_VALUE);
    }

    @Benchmark
    public void benchaccumulateAbsUntil3Pi(Blackhole bh) {
        final Random random = new Random();
        double angle = random.nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2; // initializing the angle.
        angle += Math.abs(Math.sin((new Random().nextDouble()-0.5d)*Math.PI*2d)) / PI;
    }

    private static double PI = Math.PI * 3;



    @Benchmark
    public void benchAdd(Blackhole bh) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0, lgth=10000; i<lgth; i++) {
            list.add(new Random().nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2);
        }
    }

    final Comparator comp = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };


    @Benchmark
    public void benchSort(Blackhole bh) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0, lgth=10000; i<lgth; i++) {
            // Not fine since it also benchmarks the add...
            list.add(new Random().nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2);
            list.sort(comp);
        }
    }

    @Benchmark
    public void benchaddFunctionFOR(Blackhole bl) {
        double sinSum = 0;
        final MyFunction c = new FunA();

        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
    }
    final MyFunction f = new MyFunction() {
        final double w = PI;

        public double calc(double x) {
            return Math.log(w) * x;
        }
    };

    @Benchmark
    public void benchaddFunctionFCT(Blackhole bl) {
        double sinSum = 0;
        sinSum += f.calc(sinSum);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Engineer4.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }*/
