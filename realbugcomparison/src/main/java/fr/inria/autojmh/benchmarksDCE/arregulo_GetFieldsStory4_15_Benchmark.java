
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.lang.reflect.Field;


/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_GetFieldsStory4_15_Benchmark {


    public Class<?> klass;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-GetFieldsStory4-15--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_GetFieldsStory4_15_s = new Loader();
            arregulo_GetFieldsStory4_15_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            klass = arregulo_GetFieldsStory4_15_s.readSerializable();

            arregulo_GetFieldsStory4_15_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        Field[] obj = klass.getDeclaredFields();
    }
}
