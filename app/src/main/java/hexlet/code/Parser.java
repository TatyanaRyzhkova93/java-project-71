package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> readFile(String filepath) throws Exception {
        File file1 = Path.of(filepath).toAbsolutePath().toFile();
        int i = filepath.lastIndexOf('.');
        String ext = i > 0 ? filepath.substring(i + 1) : "";
        if (ext.equalsIgnoreCase("yaml") || ext.equalsIgnoreCase("yml")) {
            InputStream inputStream = new FileInputStream(file1);
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            return data;
        } else  {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file1, new TypeReference<Map<String, Object>>() { });
        }
    }
}
