package lecture2.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 감염된폴더부모역추적 {
    public static void main(String[] args) {
        String[][] folders = {
                {"root", "media"},
                {"media", "images"},
                {"media", "videos"},
                {"images", "holiday"},
                {"videos", "concert"}
        };

        String p = "holiday";
        String q = "concert";

        Map<String, String> parentMap = new HashMap<>();
        for(String[] folder : folders){
            parentMap.put(folder[1], folder[0]);
        }

        Set<String> parents = new HashSet<>();
        while (p != null) {
            parents.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if(parents.contains(q)){
                System.out.println(q);
                break;
            }
            q = parentMap.get(q);
        }
    }
}
