import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.FORMAT_PLAIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    private static String file3;
    private static String file4;
    private static String file3yaml;
    private static String file4yaml;
    private static String answer;
    @BeforeAll
    public static void beforeAll() {
        file3 = "src/test/resources/file3.json";
        file4 = "src/test/resources/file4.json";
        file3yaml = "src/test/resources/file3.yaml";
        file4yaml = "src/test/resources/file4.yaml";
        answer = "\nProperty 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
    }
    @Test
    public void testGenerateYaml() throws Exception {
        String diff = Differ.generate(file3yaml, file4yaml, FORMAT_PLAIN);
        assertEquals(answer, diff);
    }

    @Test
    public void testGenerateJson() throws Exception {
        String diff = Differ.generate(file3, file4, FORMAT_PLAIN);
        assertEquals(answer, diff);
    }
}
