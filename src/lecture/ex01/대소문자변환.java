package lecture.ex01;

public class 대소문자변환 {
    public static void main(String[] args) {
        String s = "c111at and 2d123o456gs";

        String[] tokens = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < tokens.length; t++) {
            String token = tokens[t];
            int n = token.length();

            // 각 위치 기준: 왼쪽에 알파벳이 있었는지
            boolean[] hasLetterLeft = new boolean[n];
            boolean seenLetter = false;
            for (int i = 0; i < n; i++) {
                hasLetterLeft[i] = seenLetter;
                if (Character.isLetter(token.charAt(i))) seenLetter = true;
            }

            // 각 위치 기준: 오른쪽에 알파벳이 있는지
            boolean[] hasLetterRight = new boolean[n];
            seenLetter = false;
            for (int i = n - 1; i >= 0; i--) {
                hasLetterRight[i] = seenLetter;
                if (Character.isLetter(token.charAt(i))) seenLetter = true;
            }

            StringBuilder cleaned = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char ch = token.charAt(i);

                // 숫자이고, 왼쪽/오른쪽 모두 알파벳이 있으면 제거
                if (Character.isDigit(ch) && hasLetterLeft[i] && hasLetterRight[i]) {
                    continue;
                }

                cleaned.append(ch);
            }

            result.append(cleaned);
            if (t < tokens.length - 1) result.append(" ");
        }

        System.out.println(result.toString()); // cat and 2dogs
    }
}
