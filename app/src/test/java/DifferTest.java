import hexlet.code.Differ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private String file1;
    private String file2;
    private String file3;
    @BeforeEach
    public void beforeAll() {
        file1 = "src/test/resources/file1.json";
        file2 = "src/test/resources/file2.json";
        file3 = "src/test/resources/file3.json";

    }
    @Test
    public void testGenerate() throws Exception {
        String answer = "\n{\n- follow: false\n  host: hexlet.io\n- proxy:"
                + " 123.234.53.22\n- timeout: 50\n+ timeout: 20\n+ verbose: true\n}";
        String diff = new Differ().generate(file1, file2);
        assertEquals(answer, diff);
    }
    @Test
    public void emptyJson() throws Exception {
        String answer = "\n{\n  follow: false\n  host: hexlet.io\n  proxy: 123.234.53.22\n  timeout: 50\n}";
        String diff = new Differ().generate(file1, file3);
        assertEquals(answer, diff);
    }
}
