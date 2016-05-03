
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.math.BigInteger;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_BigIntegerConstantt8152910_14_Benchmark {


    @Benchmark
    public void doBenchmark() {
        BigInteger obj = BigInteger.ONE;
    }
}
