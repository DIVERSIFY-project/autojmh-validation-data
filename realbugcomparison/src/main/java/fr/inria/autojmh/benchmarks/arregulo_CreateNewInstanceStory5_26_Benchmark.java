
package fr.inria.autojmh.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 *  Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class arregulo_CreateNewInstanceStory5_26_Benchmark {


    public java.lang.Class<?> klass;

    public java.lang.Class<?> _class;

    public java.lang.Object obj;

    public java.lang.reflect.Constructor<?> ctr;

    public java.util.Date arg1;

    public java.lang.String arg2;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "arregulo-CreateNewInstanceStory5-26--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader arregulo_CreateNewInstanceStory5_26_s = new Loader();
            arregulo_CreateNewInstanceStory5_26_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            klass = arregulo_CreateNewInstanceStory5_26_s.readSerializable();
            _class = arregulo_CreateNewInstanceStory5_26_s.readSerializable();
            arg1 = arregulo_CreateNewInstanceStory5_26_s.readSerializable();
            arg2 = arregulo_CreateNewInstanceStory5_26_s.readSerializable();

            arregulo_CreateNewInstanceStory5_26_s.closeStream();
        } catch(Exception e) { throw new RuntimeException(e); }
    }

    

    @Benchmark
    public Object doBenchmark() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

    java.lang.reflect.Constructor<?> ctr = klass.getConstructor(Date.class, String.class);
    return ctr.newInstance(arg1,arg2);


        
    }
}
