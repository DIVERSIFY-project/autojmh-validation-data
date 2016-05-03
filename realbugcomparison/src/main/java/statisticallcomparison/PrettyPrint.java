package statisticallcomparison;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

/**
 * A class to recover and print data in diff format,
 * <p>
 * Created by marodrig on 12/04/2016.
 */
public class PrettyPrint {

    private static class Result {
        double value;

        double err;

        Result(double val, double err) {
            this.value = val;
            this.err = err;
        }
    }

    public static void main(String[] args) throws IOException, ParseException {


        HashMap<String, String> humanVsAuto = new HashMap<>();

        //Uncomment these lines to print results
        //String benchmarks = "benchmarkCF";
        String benchmarks = "benchmarksDCE";
        //String benchmarks = "benchmarkBadInit";
        //String benchmarks = "benchmarks";

        humanVsAuto.put(benchmarks + ".oraclebugs_BigIntegerConstantt8152910_14_Benchmark.doBenchmark",
                "humanmade.oracle.BigIntegerBenchBUG8152910.ONE");
        humanVsAuto.put(benchmarks + ".oraclebugs_BigIntegerConstantt8152910_17_Benchmark.doBenchmark",
                "humanmade.oracle.BigIntegerBenchBUG8152910.valueOf_1");
        humanVsAuto.put(benchmarks + ".oraclebugs_BigIntegerConstantt8152910_20_Benchmark.doBenchmark",
                "humanmade.oracle.BigIntegerBenchBUG8152910.valueOf_2");


        humanVsAuto.put(benchmarks + ".arregulo_CreateNewInstanceStory5_41_Benchmark.doBenchmark",
                "humanmade.arregulo.reflection.CreateNewInstance.new_allocate");
        humanVsAuto.put(benchmarks + ".arregulo_CreateNewInstanceStory5_26_Benchmark.doBenchmark",
                "humanmade.arregulo.reflection.CreateNewInstance.find_constructor_allocate");
        humanVsAuto.put(benchmarks + ".arregulo_CreateNewInstanceStory5_15_Benchmark.doBenchmark",
                "humanmade.arregulo.reflection.CreateNewInstance.load_class_find_constructor_allocate");

        humanVsAuto.put(benchmarks + ".arregulo_GetFieldsStory4_15_Benchmark.doBenchmark",
                "humanmade.arregulo.reflection.GetFields.getDeclaredFields");


        humanVsAuto.put(benchmarks + ".arregulo_LongKeyMapStory2_18_Benchmark.doBenchmark",
                "humanmade.arregulo.map.LongKeyMap.get_NonBlockingHashMapLong");
        humanVsAuto.put(benchmarks + ".arregulo_LongKeyMapStory2_13_Benchmark.doBenchmark",
                "humanmade.arregulo.map.LongKeyMap.get_ConcurrentHashMap");

        humanVsAuto.put(benchmarks + ".arregulo_IgnoreCaseStory3_24_Benchmark.doBenchmark",
                "humanmade.arregulo.map.MapGet.IgnoreCaseMap");
        humanVsAuto.put(benchmarks + ".arregulo_IgnoreCaseStory3_13_Benchmark.doBenchmark",
                "humanmade.arregulo.map.MapGet.HashMap_toLowerCase");
        humanVsAuto.put(benchmarks + ".arregulo_IgnoreCaseStory3_18_Benchmark.doBenchmark",
                "humanmade.arregulo.map.MapGet.TreeMap");


        humanVsAuto.put(benchmarks + ".oraclebugs_PatternMatcher8151481_15_Benchmark.doBenchmark",
                "humanmade.oracle.PatternMatcherBUG8151481.testMethod");


        humanVsAuto.put(
                benchmarks + ".oraclebugs_StringFormat8050142_13_Benchmark.doBenchmark",
                "humanmade.oracle.StringFormatBUG8050142.formatDecimal");
        humanVsAuto.put(
                benchmarks + ".oraclebugs_StringFormat8050142_17_Benchmark.doBenchmark",
                "humanmade.oracle.StringFormatBUG8050142.formatHex");
        humanVsAuto.put(
                benchmarks + ".oraclebugs_StringFormat8050142_21_Benchmark.doBenchmark",
                "humanmade.oracle.StringFormatBUG8050142.formatDouble");
        humanVsAuto.put(
                benchmarks + ".oraclebugs_StringFormat8050142_25_Benchmark.doBenchmark",
                "humanmade.oracle.StringFormatBUG8050142.formatScience");
        humanVsAuto.put(
                benchmarks + ".oraclebugs_StringFormat8050142_29_Benchmark.doBenchmark",
                "humanmade.oracle.StringFormatBUG8050142.formatString");
        humanVsAuto.put(
                benchmarks + ".oraclebugs_StringFormat8050142_33_Benchmark.doBenchmark",
                "humanmade.oracle.StringFormatBUG8050142.formatComplex");

        humanVsAuto.put(
                benchmarks + ".oraclebugs_ForStream8146071_13_Benchmark.doBenchmark",
                "humanmade.oracle.ForStreamBUG8146071.forTest_if");
        humanVsAuto.put(
                benchmarks + ".oraclebugs_ForStream8146071_25_Benchmark.doBenchmark",
                "humanmade.oracle.ForStreamBUG8146071.forTest_MathMax");


        humanVsAuto.put(benchmarks + ".arregulo_CollectionToListStory6_16_Benchmark.doBenchmark",
                "humanmade.arregulo.CollectionToList.new_ArrayList_from_Collection");
        humanVsAuto.put(benchmarks + ".arregulo_CollectionToListStory6_33_Benchmark.doBenchmark",
                "humanmade.arregulo.CollectionToList.new_ArrayList_add");


        String fileName = "C:\\MarcelStuff\\DATA\\PHD\\realbugcomparison\\results\\result";

        HashMap<String, Double> mean = new HashMap<>();
        List<HashMap<String, Result>> allResults = new ArrayList<>();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVW";
        //System.out.print("#;");
        for (int i = 0; i < alphabet.length(); i++) {
            System.out.print(String.format("%s; %s;", alphabet.charAt(i), alphabet.charAt(i) + "_"));
        }
        System.out.println();
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        for (int i = 1; i < 32; i++) {
            //System.out.print(String.format(i + ";"));
            List<String> lines = FileUtils.readLines(new File(fileName + i + ".txt"), "utf-8");
            HashMap<String, Result> results = new HashMap<>();
            allResults.add(results);
            for (String line : lines) {
                String[] vals = line.split(";");
                for (int k = 0; k < vals.length; k++) vals[k] = vals[k].trim();
                try {
                    Result r = new Result(format.parse(vals[1]).doubleValue(), format.parse(vals[2]).doubleValue());
                    if (!mean.containsKey(vals[0])) mean.put(vals[0], 0.0);
                    mean.put(vals[0], mean.get(vals[0]) + r.value);
                    results.put(vals[0], r);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage() + " " + vals[0]);
                }
            }
        }

        //List<String> errors = new ArrayList<>();

        try {
            for (int i = 1; i < 32; i++) {
                HashMap<String, Result> results = allResults.get(i);
                for (Map.Entry<String, String> entry : humanVsAuto.entrySet()) {
                    if (results.containsKey(entry.getKey())) {
                        try {
                            double m = mean.get(entry.getKey()) / 32;
                            double hVal = results.get(entry.getKey()).value;// / m;
                            double aVal = results.get(entry.getValue()).value;// / m;
                            System.out.print(String.format("%.3f; %.3f;", hVal, aVal));
                        } catch (Exception ex) {
                            System.out.println("Could not find:" + entry.getKey());
                            System.out.println("Could not find:" + entry.getValue());
                        }
                    }

                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }

        int k = 0;
        for (Map.Entry<String, String> entry : humanVsAuto.entrySet()) {
            System.out.println(alphabet.charAt(k++) + ":  " + entry.getValue() + " - " + entry.getKey());
        }

        //for (String s : errors) System.out.println(s);
    }


}
