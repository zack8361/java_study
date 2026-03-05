package lecture2.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 감염된폴더 {
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

        Map<String, List<String>> tree = new HashMap<>();


        for(String[] folder : folders) {
            String key = folder[0];
            String value = folder[1];
            tree.putIfAbsent(key, new ArrayList<>());
            tree.get(key).add(value);
        }

        System.out.println(dfs(tree, "root",p,q));

    }

    private static String dfs(Map<String, List<String>> tree, String node, String p, String q) {

        if(node.equals(p) || node.equals(q)) {
            return node;
        }

        List<String> found = new ArrayList<>();
        List<String> childern = tree.getOrDefault(node, new ArrayList<>());

        for (String child : childern) {
            String res = dfs(tree, child, p, q);
            if(res != null) {
                found.add(res);
            }
        }

        if(found.size() == 2) return node;
        if(found.size() == 1) return found.get(0);

        return null;
    }
}
