package hexlet.code.formatters;

import java.util.Map;

public class Stylish implements Format {

    @Override
    public String generateEquals(Map<String, Object> map) {
        StringBuilder stb = new StringBuilder();
        stb.append("{\n");
        for (Map.Entry<String, Object> m : map.entrySet()) {
            stb.append("  ")
                    .append(m.getKey()).append(": ")
                    .append(m.getValue() == null ? null : m.getValue().toString())
                    .append("\n");
        }
        stb.append("}");
        return stb.toString();
    }
}
