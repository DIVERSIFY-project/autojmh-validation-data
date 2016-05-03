
package fr.inria.autojmh.benchmarkCF;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_StringFormat8050142_25_Benchmark {


    public static final double pi = Math.PI;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "oraclebugs-StringFormat8050142-25--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader oraclebugs_StringFormat8050142_25_s = new Loader();
            oraclebugs_StringFormat8050142_25_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            //pi = oraclebugs_StringFormat8050142_25_s.readdouble();

            oraclebugs_StringFormat8050142_25_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public String doBenchmark() {
    return String.format("%5.5e",pi);

        
    }
}
