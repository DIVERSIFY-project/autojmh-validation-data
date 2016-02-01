package fr.inria.diverse.autojmh.validation.eng3;

import fr.inria.benchexp.samples.FunA;
import fr.inria.benchexp.samples.FunB;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 *  ---- Microbenchmark 1 -----
 *
 * This microbenchmark serves to demonstrate the somehow self-evident
 * but frequently ignored fact the performance of one segment of code
 * not only depends on the value of the variables, but also
 * on their types.
 *
 * Created by marodrig on 07/12/2015.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DifferentInheritorsEng3 {

    private double sinSum;

    @Benchmark
    public double baselineValidated() {
        return 0.0;
    }

    @Benchmark
    public void benchFunAArray100Eng3(Blackhole bh) {
        double sinSum = 0;
        FunA c = new FunA();
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
        bh.consume(sinSum);
    }

    @Benchmark
    public double benchFunBArray100Eng3() {
        FunB c = new FunB();
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
        return sinSum;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DifferentInheritorsEng3.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}


/*
    private List<Integer> a;
    private Random random;

    @Setup(Level.Invocation)
    public void setup() {
        random = new Random();
        a = new ArrayList<Integer>();
        for (int i = 0; i < random.nextInt(); i++) {
            a.add(random.nextInt());
        }
    }


    @Benchmark
    public void doBenchmark2(Blackhole bh) {
        double sinSum = 0;
        final double w = PI;

        MyFunction f = new MyFunction() {
            public double calc(double x) {
                return Math.log(w) * x;
            }
        };
        sinSum += f.calc(sinSum);
        bh.consume(sinSum);
    }


    @Benchmark
    public void doBenchmark5(Blackhole bh) {
        double angle = random.nextDouble();
        double y = angle;
        angle += Math.abs(Math.sin(y)) / PI;
        bh.consume(angle);
    }

    @Benchmark
    public void doBenchmark6(Blackhole bh) {
        double x = random.nextDouble();
        double y = random.nextDouble();
        x = Math.abs(x) < 0.0000001 ? 1.00 : x;
        y = Math.abs(y) < 0.0000001 ? 1.00 : y;
        double c = x * y;
        bh.consume(c);
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Engineer3.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }*/
