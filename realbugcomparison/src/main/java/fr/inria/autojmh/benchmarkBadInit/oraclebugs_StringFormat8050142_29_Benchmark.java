
package fr.inria.autojmh.benchmarkBadInit;

import org.openjdk.jmh.annotations.*;


/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_StringFormat8050142_29_Benchmark {


    public String str;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "oraclebugs-StringFormat8050142-29--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup(Level.Invocation)
    public void setup() {
        try {
            Loader oraclebugs_StringFormat8050142_29_s = new Loader();
            oraclebugs_StringFormat8050142_29_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            str = oraclebugs_StringFormat8050142_29_s.readSerializable();

            oraclebugs_StringFormat8050142_29_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }



    @Benchmark
    public String doBenchmark() {
    return String.format("%s",str);

        
    }
}
