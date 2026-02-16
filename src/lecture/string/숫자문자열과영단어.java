package lecture.string;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        String s = "23four5six7";
        solution(s);
    }
    private static void solution(String s) {
        String answer = "";
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);

        System.out.println(answer);
    }
}
