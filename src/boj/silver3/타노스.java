package boj.silver3;

import java.util.Scanner;

public class 타노스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();


        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }
        countZero /=2;
        countOne /=2;

        System.out.println("countOne = " + countOne);
        System.out.println("countZero = " + countZero);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< number.length(); i++){
            if(number.charAt(i) == '1' && countOne > 0){
                countOne--;
            } else {
                sb.append(number.charAt(i));
            }
        }

        for(int i = sb.length()-1; i>=0; i--) {
            if(sb.charAt(i) == '0' && countZero > 0){
                countZero--;
                sb.deleteCharAt(i);
            }
        }
    }
}
