package programmers.lv1.solved.low;

public class 문자열반환 {
    public static void main(String[] args) {
        System.out.println(solution("pPooyY"));
    }

    private static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        s = s.toLowerCase();

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p') {
                pCount++;
            } else if(c == 'y') {
                yCount++;
            }
        }

        if(pCount == yCount) return true;

        return false;
    }
}
