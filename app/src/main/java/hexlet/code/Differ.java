package hexlet.code;

import picocli.CommandLine;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@CommandLine.Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
public class Differ implements Runnable {

    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to first file")
    private String filepath2;
    @CommandLine.Option(names = {"-f", "--format"},
            description = "output format [default: stylish]")
    String format = "stylish";

    public String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, format);
    }

    public String generate(String path1, String path2, String nameFormat) throws Exception {
        Map<String, Object> sorted1 = Parser.readFile(path1);
        Map<String, Object> sorted2 = Parser.readFile(path2);
        Comparator<String> comparator = getComparator();
        SortedMap<String, Object> result = new TreeMap<>(comparator);
        for (var entry : sorted1.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (sorted2 == null ? false : sorted2.containsKey(key)) {
                if (value == null ? sorted2.get(key) == null : value.equals(sorted2.get(key))) {
                    result.put("  " + key, value);
                } else {
                    result.put("- " + key, value);
                    result.put("+ " + key, sorted2.get(key));
                }
                sorted2.remove(key);
            } else {
                result.put("- " + key, value);
            }
        }
        if (sorted2 != null) {
            for (var entry : sorted2.entrySet()) {
                result.put("+ " + entry.getKey(), entry.getValue());
            }
        }
        return Formatter.createFormatter(nameFormat, result);
    }

    @Override
    public void run() {
        try {
            System.out.println(generate(filepath1, filepath2, format));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static Comparator<String> getComparator() throws RuntimeException {
        return  (s1, s2) -> {
            if (s1.charAt(0) == '+' && s1.substring(1).equals(s2.substring(1))) {
                return s1.compareTo(s2.substring(1));
            } else if (s1.charAt(0) == '-' && s1.substring(1).equals(s2.substring(1))) {
                return s1.substring(1).compareTo(s2);
            } else {
                return s1.substring(1).compareTo(s2.substring(1));
            }
        };
    }

}
