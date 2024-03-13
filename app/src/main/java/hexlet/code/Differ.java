package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;

import java.io.File;
import java.nio.file.Path;
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
    @CommandLine.Option(names = {"-f, --format"}, paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";

    public String generate(String path1, String path2) throws Exception {
        Map<String, Object> sorted1 = readFileJson(path1);
        Map<String, Object> sorted2 = readFileJson(path2);
        Comparator<String> comparator = getComparator();
        SortedMap<String, Object> result = new TreeMap<>(comparator);
        for (var entry : sorted1.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (sorted2.containsKey(key)) {
                if (value.equals(sorted2.get(key))) {
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
        for (var entry : sorted2.entrySet()) {
            result.put("+ " + entry.getKey(), entry.getValue());
        }

        return result.toString().replace(", ", "\n").replace("=", ": ")
                .replace("{", "\n{\n").replace("}", "\n}");
    }

    @Override
    public void run() {
        try {
            System.out.println(generate(filepath1, filepath2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Object> readFileJson(String filepath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file1 = Path.of(filepath).toAbsolutePath().toFile();
        Map<String, Object> map = mapper.readValue(file1, Map.class);
        return map;
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
