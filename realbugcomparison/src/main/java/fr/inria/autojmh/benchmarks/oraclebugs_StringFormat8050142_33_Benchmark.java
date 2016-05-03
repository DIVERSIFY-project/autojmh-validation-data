
package fr.inria.autojmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_StringFormat8050142_33_Benchmark {


    public int value;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "oraclebugs-StringFormat8050142-33--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader oraclebugs_StringFormat8050142_33_s = new Loader();
            oraclebugs_StringFormat8050142_33_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            value = 4771;// oraclebugs_StringFormat8050142_33_s.readint();

            oraclebugs_StringFormat8050142_33_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public java.lang.String doBenchmark() {
        return java.lang.String.format("  %04x %05x %06x %05x", value, value, value, value);
    }
}
