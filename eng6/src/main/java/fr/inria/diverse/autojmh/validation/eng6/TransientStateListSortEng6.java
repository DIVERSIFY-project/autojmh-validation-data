package fr.inria.diverse.autojmh.validation.eng6;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
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
public class TransientStateListSortEng6 {

    ArrayList<Integer> a ;
    Random r;
    @Setup(Level.Trial)
    public void setUp(){

        a = new ArrayList<Integer>(10);
        r = new Random();
        for(int i=0;i<10;i++){
            a.add(r.nextInt());
        }
    }

    @Benchmark
    @OperationsPerInvocation(2)
    public void benchSort() {
        a.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        a.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -o1 - o2;
            }
        });
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TransientStateListSortEng6.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

/*
    MyFunction c;
    @Benchmark
    public void doBenchmark(Blackhole bh ) {
        double sinSum = 0;
        if (c == null) c = new FunA();
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
    }

    @Benchmark
    public void doBenchmark2(Blackhole bh ) {
        double sinSum = 0;
        final double w = Math.PI * 3;
        MyFunction f = new MyFunction() {
            public double calc(double x) {
                return Math.log(w) * x;
            }
        };
        sinSum += f.calc(sinSum);
    }

    ArrayList<Integer> a;
    int value;
    @Setup(Level.Invocation)
    public void set(){
        a = new ArrayList<Integer>();
        a.add(1);
        a.add(100);
        a.add(8);
        value = 3;
    }

    @Benchmark
    public void doBenchmark3(Blackhole bh ) {
        a.add(value);
    }

    @Benchmark
    public void doBenchmark4(Blackhole bh ) {
        a.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    double y;
    double angle;
    double sinSum;
    @Setup(Level.Invocation)
    public void set1(){
        sinSum = 0;
        y = angle;
        angle = angle + sinSum * 0.0000001;
    }

    @Benchmark
    public void doBenchmark5(Blackhole bh ) {
        angle += Math.abs(Math.sin(y)) / Math.PI * 3;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Engineer5.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }*/

