package lecture.string;

import java.util.Arrays;

public class 암호 {
    public static void main(String[] args) {
        int n = 4;
        String str = "#****###**#####**#####**##**";

        String[] strArr = new String[n];

        for(int i = 0; i < n; i++) {
            String piece = str.substring(i*7, (i+1)*7);

            String ans = "";
            for(int j = 0; j < piece.length(); j++) {
                if(piece.charAt(j) == '#') {
                    ans += "1";
                } else {
                    ans += "0";
                }
            }
            strArr[i] = ans;
        }

        String answer = "";
        for(String s : strArr) {
            int i = Integer.parseInt(s, 2);
            answer += (char) i;
        }

        System.out.println(answer);

    }
}
