package programmers.example;

public class SubStringExample {
    public static void main(String[] args) {

        String s = "1234";

        for(int i=1; i<=s.length()/2; i++){
            String substring = s.substring(0, i);
            System.out.println(substring);
            for(int j=i; j<s.length(); j++){
                System.out.print(s.charAt(j) + " ");
            }
            System.out.println();
        }
    }
}
