
package fr.inria.autojmh.benchmarkBadInit;

import org.openjdk.jmh.annotations.*;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_CreateNewInstanceStory5_41_Benchmark {


    public java.util.Date arg1;

    public String arg2;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-CreateNewInstanceStory5-41--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_CreateNewInstanceStory5_41_s = new Loader();
            arregulo_CreateNewInstanceStory5_41_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            arg1 = arregulo_CreateNewInstanceStory5_41_s.readSerializable();
            arg2 = arregulo_CreateNewInstanceStory5_41_s.readSerializable();

            arregulo_CreateNewInstanceStory5_41_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }

    

    @Benchmark
    public arregulo.C doBenchmark() {
    return new arregulo.C(arg1 , arg2);

        
    }
}
