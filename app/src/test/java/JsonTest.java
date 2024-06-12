import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    private static String file1;
    private static String file2;
    private static final String FORMAT_JSON = "json";
    @BeforeAll
    public static void beforeAll() {
        file1 = "src/test/resources/file3.json";
        file2 = "src/test/resources/file4.json";
    }
    @Test
    public void testGenerateJson() throws Exception {
        String answer = "{\"  chars1\":[\"a\",\"b\",\"c\"],"
                + "\"- chars2\":[\"d\",\"e\",\"f\"],"
                + "\"+ chars2\":false,"
                + "\"- checked\":false,\"+ checked\":true,\"- default\":null,"
                + "\"+ default\":[\"value1\",\"value2\"],\"- id\":45,\"+ id\":null,"
                + "\"- key1\":\"value1\",\"+ key2\":\"value2\",\"  numbers1\":[1,2,3,4],"
                + "\"- numbers2\":[2,3,4,5],\"+ numbers2\":[22,33,44,55],"
                + "\"- numbers3\":[3,4,5],\"+ numbers4\":[4,5,6],"
                + "\"+ obj1\":{\"nestedKey\":\"value\",\"isNested\":true},"
                + "\"- setting1\":\"Some value\",\"+ setting1\":\"Another value\","
                + "\"- setting2\":200,\"+ setting2\":300,\"- setting3\":true,\"+ setting3\":\"none\"}";
        String diff = new Differ().generate(file1, file2, FORMAT_JSON);
        assertEquals(answer, diff);
    }
}
