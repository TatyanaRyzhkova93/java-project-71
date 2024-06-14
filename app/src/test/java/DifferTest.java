import hexlet.code.Differ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String file1;
    private static String file2;
    private static String file3;
    private static String file4;
    private static String file1yaml;
    private static String file2yaml;
    private static String file3yaml;
    private static String file4yaml;
    private static String answer;
    private static String answer2;
    private static String answer3;
    @BeforeAll
    public static void beforeAll() {
        file1 = "src/test/resources/file1.json";
        file2 = "src/test/resources/file2.json";
        file3 = "src/test/resources/file3.json";
        file4 = "src/test/resources/file4.json";
        file1yaml = "src/test/resources/file1.yaml";
        file2yaml = "src/test/resources/file2.yaml";
        file3yaml = "src/test/resources/file3.yaml";
        file4yaml = "src/test/resources/file4.yaml";
        answer = "{\n"
                + "   chars1: [a, b, c]\n"
                + " - chars2: [d, e, f]\n"
                + " + chars2: false\n"
                + " - checked: false\n"
                + " + checked: true\n"
                + " - default: null\n"
                + " + default: [value1, value2]\n"
                + " - id: 45\n"
                + " + id: null\n"
                + " - key1: value1\n"
                + " + key2: value2\n"
                + "   numbers1: [1, 2, 3, 4]\n"
                + " - numbers2: [2, 3, 4, 5]\n"
                + " + numbers2: [22, 33, 44, 55]\n"
                + " - numbers3: [3, 4, 5]\n"
                + " + numbers4: [4, 5, 6]\n"
                + " + obj1: {nestedKey=value, isNested=true}\n"
                + " - setting1: Some value\n"
                + " + setting1: Another value\n"
                + " - setting2: 200\n"
                + " + setting2: 300\n"
                + " - setting3: true\n"
                + " + setting3: none\n"
                + "}";
        answer2 = "{\n"
                + " - chars1: [a, b, c]\n"
                + " - chars2: [d, e, f]\n"
                + " - checked: false\n"
                + " - default: null\n"
                + " - id: 45\n"
                + " - key1: value1\n"
                + " - numbers1: [1, 2, 3, 4]\n"
                + " - numbers2: [2, 3, 4, 5]\n"
                + " - numbers3: [3, 4, 5]\n"
                + " - setting1: Some value\n"
                + " - setting2: 200\n"
                + " - setting3: true\n"
                + "}";
        answer3 = "{\n   follow: false\n   host: hexlet.io\n   proxy: 123.234.53.22\n   timeout: 50\n}";
    }
    @Test
    public void testGenerateJsonEmptyFile() throws Exception {
        String diff = new Differ().generate(file3, file2);
        assertEquals(answer2, diff);
    }
    @Test
    public void testGenerateYamlEmptyFile() throws Exception {
        String diff = new Differ().generate(file3yaml, file2yaml);
        assertEquals(answer2, diff);
    }
    @Test
    public void testGenerateJson() throws Exception {
        String diff = new Differ().generate(file3, file4);
        assertEquals(answer, diff);
    }
    @Test
    public void emptyJson() throws Exception {
        String diff = new Differ().generate(file1, file1);
        assertEquals(answer3, diff);
    }
    @Test
    public void testGenerateYaml() throws Exception {
        String diff = new Differ().generate(file3yaml, file4yaml);
        assertEquals(answer, diff);
    }
    @Test
    public void emptyJsonYaml() throws Exception {
        String diff = new Differ().generate(file1yaml, file1yaml);
        assertEquals(answer3, diff);
    }
}
