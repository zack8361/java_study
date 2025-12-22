package boj.silver4;

import java.util.Scanner;

public class 뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int countZero = 0;
        int countOne = 0;

        for(int i = 0; i<str.length(); i++) {
            System.out.println(str.charAt(i));
            if(i != 0) {
                if(str.charAt(i) != str.charAt(i-1)) {
                    if(str.charAt(i) == '0') {
                        countZero++;
                    } else {
                        countOne++;
                    }
                }
            }
        }
        if((countZero == 0) || (countOne == 0)) System.out.println(1);
        else System.out.println(Math.min(countOne, countZero));
    }
}
