package fr.inria.autojmh.humanmade.oracle;

import org.openjdk.jmh.annotations.*;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/*
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.NANOSECONDS)*/
public class BigIntegerBenchBUG8152910 {
    /*
        @Benchmark
        public BigInteger ONE() {
            return BigInteger.ONE;
        }

        @Benchmark
        public BigInteger valueOf_1() {
            return BigInteger.valueOf(1);
        }
    */
    @Benchmark
    public BigInteger valueOf_2() {
        return BigInteger.valueOf(2);
    }
}