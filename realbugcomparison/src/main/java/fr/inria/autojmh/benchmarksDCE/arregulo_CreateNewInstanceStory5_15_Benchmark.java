
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_CreateNewInstanceStory5_15_Benchmark {


    public String className;

    public Class<?> clazz;

    public Class<?> _class;

    public Object obj;

    public java.lang.reflect.Constructor<?> ctr;

    public Date arg1;

    public String arg2;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-CreateNewInstanceStory5-15--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_CreateNewInstanceStory5_15_s = new Loader();
            arregulo_CreateNewInstanceStory5_15_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            className = arregulo_CreateNewInstanceStory5_15_s.readSerializable();
            _class = arregulo_CreateNewInstanceStory5_15_s.readSerializable();
            arg1 = arregulo_CreateNewInstanceStory5_15_s.readSerializable();
            arg2 = arregulo_CreateNewInstanceStory5_15_s.readSerializable();

            arregulo_CreateNewInstanceStory5_15_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        java.lang.reflect.Constructor<?> ctr = clazz.getConstructor(Date.class, String.class);
        Object objT = ctr.newInstance(arg1, arg2);
    }
}
