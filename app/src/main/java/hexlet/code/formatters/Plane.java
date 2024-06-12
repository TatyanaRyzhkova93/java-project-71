package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Plane implements Format {
    private static Object getValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value.getClass().equals(String.class)) {
            return "'" + value + "'";
        }
        if (value.getClass().equals(ArrayList.class)
                || value.getClass().equals(LinkedHashMap.class)) {
            return "[complex value]";
        }
        return value;
    }

    @Override
    public String generateEquals(Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>(map);
        String result = "\n";
        for (var entry : map.entrySet()) {
            if (entry.getKey().startsWith("- ")) {
                if (hashMap.containsKey("+ " + entry.getKey().substring(2))) {
                    result += String.format("Property '%s' was updated. From %s to %s\n",
                            entry.getKey().substring(2),
                            getValue(entry.getValue()),
                            getValue(hashMap.get("+" + entry.getKey().substring(1))));


                } else {
                    result += String.format("Property '%s' was removed\n", entry.getKey().substring(2));
                }
            } else if (entry.getKey().startsWith("+ ")) {
                if (!hashMap.containsKey("- " + entry.getKey().substring(2))) {
                    result += String.format("Property '%s' was added with value: %s\n",
                            entry.getKey().substring(2),
                            getValue(entry.getValue()));
                }
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
