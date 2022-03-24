package year2022.test.kakao0130;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
        Map<String, String> family = Map.ofEntries(
                Map.entry("Teo", "Star Wars"),
                Map.entry("Olivia", "Matrix"));
        Map<String, String> friends = Map.ofEntries(
                Map.entry("Raphael", "James Bond"),
                Map.entry("Olivia", "James Bond")
                );

        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        everyone.forEach((k, v)->{
            System.out.println(k+ v);
        });

        ConcurrentHashMap<String, String> cMap = new ConcurrentHashMap();
        cMap.put("Teo", "Star Wars");
        cMap.put("Teo1", "Star1 Wars");
        cMap.put("Teo2", "Star2 Wars");
        System.out.println(cMap);
        System.out.println(cMap.keySet("test").getMappedValue());
        System.out.println(cMap.keySet().getMappedValue());

    }
}
