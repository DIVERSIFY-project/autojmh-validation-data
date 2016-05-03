
package fr.inria.autojmh.benchmarkBadInit;

import org.openjdk.jmh.annotations.*;


/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_ForStream8146071_25_Benchmark {


    public int i;

    public int e;

    public int m;

    public int[] a;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "oraclebugs-ForStream8146071-25--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup(Level.Invocation)
    public void setup() {
        try {
            Loader oraclebugs_ForStream8146071_25_s = new Loader();
            oraclebugs_ForStream8146071_25_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            e = oraclebugs_ForStream8146071_25_s.readint();
            m = oraclebugs_ForStream8146071_25_s.readint();
            a = oraclebugs_ForStream8146071_25_s.readArray1int();

            oraclebugs_ForStream8146071_25_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }

    

    @Benchmark
    public void doBenchmark() {
    for (int i = 0 ; i < e ; i++)
    m = Math.max(m,a[i]);;

        
    }
}
