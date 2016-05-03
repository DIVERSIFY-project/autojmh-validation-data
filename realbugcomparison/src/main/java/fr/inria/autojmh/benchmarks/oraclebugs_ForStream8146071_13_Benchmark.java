
package fr.inria.autojmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import static org.hsqldb.HsqlDateTime.e;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_ForStream8146071_13_Benchmark {


    public int i;

    public int e;

    public int[] ints;

    public int m;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "oraclebugs-ForStream8146071-13--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader oraclebugs_ForStream8146071_13_s = new Loader();
            oraclebugs_ForStream8146071_13_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            e = oraclebugs_ForStream8146071_13_s.readint();
            ints = oraclebugs_ForStream8146071_13_s.readArray1int();
            m = oraclebugs_ForStream8146071_13_s.readint();

            oraclebugs_ForStream8146071_13_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public int doBenchmark() {
        int[] a = ints;
        int e = a.length;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < e; i++)
            if (a[i] >= m)
                m = a[i];
        return m;
    }
}
