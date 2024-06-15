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
    private static ObjectMapper createMapper(String name) {

        int i = name.lastIndexOf('.');
        String ext = i > 0 ? name.substring(i + 1) : "";
        if (ext.equalsIgnoreCase("json")) {
            return new ObjectMapper();
        } else if (ext.equalsIgnoreCase("yaml")) {
            return new YAMLMapper();
        }
        return new ObjectMapper();
    }
}
