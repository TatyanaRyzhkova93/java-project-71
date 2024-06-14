package hexlet.code.formatters;

import java.util.HashMap;
import java.util.Map;

public class Stylish implements Format {

    @Override
    public String generateEquals(Map<String, Object> map) {
        Map<String, String> mapString = new HashMap<>();
        for (Map.Entry<String, Object> m : map.entrySet()) {
            mapString.put(m.getKey(), m.getValue() == null ? null : m.getValue().toString());
        }
        String s = map.toString()
                .replace(", +", "\n+")
                .replace(", -", "\n-")
                .replace(",  ", "\n ")
                .replace("=", ": ")
                .replace("{ ", "\n{\n ")
                .replace("{+", "\n{\n+")
                .replace("{-", "\n{\n-");
        return s.substring(0, s.length() - 1) + "\n}";
    }
}
