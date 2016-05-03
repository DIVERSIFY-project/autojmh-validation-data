
package fr.inria.autojmh.benchmarksDCE;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Benchmark auto generated using AutoJMH
 */
@State(Scope.Thread)
public class oraclebugs_PatternMatcher8151481_15_Benchmark {


    public String[][] data;

    public int n;

    public boolean result;

    public java.util.regex.Matcher matcher;

    public String input;

    static final String DATA_ROOT_FOLDER = "C:/MarcelStuff/DATA/PHD/jmhrealbugs_work/log";
    static final String DATA_FILE = "oraclebugs-PatternMatcher8151481-15--main-sun.misc.Launcher$AppClassLoader@6bc7c054";

    @Setup//(Level.Invocation)
    public void setup() {
        try {
            Loader oraclebugs_PatternMatcher8151481_15_s = new Loader();
            oraclebugs_PatternMatcher8151481_15_s.openStream(DATA_ROOT_FOLDER, DATA_FILE);

            data = oraclebugs_PatternMatcher8151481_15_s.readArray2String();
            n = oraclebugs_PatternMatcher8151481_15_s.readint();
            input = oraclebugs_PatternMatcher8151481_15_s.readSerializable();

            oraclebugs_PatternMatcher8151481_15_s.closeStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Benchmark
    public void doBenchmark() {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(data[n][0]).matcher("");
        boolean obj = matcher.reset(input).matches();
    }
}
