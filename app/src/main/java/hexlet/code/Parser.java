package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> readFile(String filepath) throws Exception {
        ObjectMapper mapper = createMapper(filepath);
        File file1 = Path.of(filepath).toAbsolutePath().toFile();
        Map<String, Object> map = mapper.readValue(file1, Map.class);
        return map;
    }
    private static ObjectMapper createMapper(String filepath) {
        if (filepath.endsWith("json")) {
            return new ObjectMapper();
        } else if (filepath.endsWith("yaml")) {
            return new YAMLMapper();
        }
        return null;
    }
}
