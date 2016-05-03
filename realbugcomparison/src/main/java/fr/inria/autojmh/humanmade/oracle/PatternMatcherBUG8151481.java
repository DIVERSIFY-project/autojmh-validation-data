package fr.inria.autojmh.humanmade.oracle;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;


import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class PatternMatcherBUG8151481 {

    //@Param({"0", "1", "2", "3", "4"})
    @Param({"0"})
    int n;

    String data[][] = {
            {"a+a+", "aaaaaaaaaaaaaaaaaaaaaaa" },
            {"a+a+", "aaaaaaaaaaaaaaaaaaaaaab" },
            { "[a-zABCDEFGHIJKLMN]", "A" },
            { "[a-zABCDEFGHIJKLMN]", "Z" },
            {"\\p{javaLetter}", "aaaaaaaaaaaaaaaaaaaaaaa" },
            {"\\p{javaLetter}", "aaaaaaaaaaaaaaaaaaaaaaa-" },
    };

    Matcher matcher;
    String input;

    @Setup
    public void setup() throws Throwable {
        matcher = Pattern.compile(data[n][0]).matcher("");
        input = data[n][1];
    }

    @Benchmark
    public void testMethod() {
        matcher.reset(input).matches();
    }

}
