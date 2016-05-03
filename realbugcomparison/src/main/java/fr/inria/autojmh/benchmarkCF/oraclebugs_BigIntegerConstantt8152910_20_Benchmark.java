
package fr.inria.autojmh.benchmarkCF;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_BigIntegerConstantt8152910_20_Benchmark {


    public long k = 2L;
    

    @Benchmark
    public java.math.BigInteger doBenchmark() {
    return java.math.BigInteger.valueOf(k);
    }
}
