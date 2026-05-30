package lecture.string;

public class 문자열압축 {
    public static void main(String[] args) {
        String s = "KKHSSSSSSSE ";

        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length()-1; i++) {
            String curr =  String.valueOf(s.charAt(i));
            String next = String.valueOf(s.charAt(i+1));

            if(curr.equals(next)) cnt ++;
            else {
                if(cnt == 1) sb.append(curr);
                else sb.append(curr).append(cnt);
                cnt = 1;
            }
        }
        System.out.println(sb);
    }
}
