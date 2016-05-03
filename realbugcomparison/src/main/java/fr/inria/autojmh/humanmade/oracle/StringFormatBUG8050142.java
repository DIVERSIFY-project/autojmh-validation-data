package fr.inria.autojmh.humanmade.oracle;

/**
 * Created by marodrig on 12/04/2016.
 */

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class StringFormatBUG8050142 {
    public int value = 4711;

    public int width = 6;

    public float pi = (float) Math.PI;

    public String str = "foo";
/*
    @Benchmark
    public String formatDecimal() {
        return String.format("%d", value);
    }

    @Benchmark
    public String formatHex() {
        return String.format("%06x", value);
    }

    @Benchmark
    public String formatDouble() {
        return String.format("%.4f", pi);
    }
    */
    @Benchmark
    public String formatScience() {
        return String.format("%5.5e", pi);
    }
/*
    @Benchmark
    public String formatComplex() {
        return String.format("  %04x %05x %06x %05x", value, value, value, value);
    }

    @Benchmark
    public String formatString() {
        return String.format("%s", str);
    }
    */
}
