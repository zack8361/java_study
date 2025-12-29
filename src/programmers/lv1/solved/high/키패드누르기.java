package programmers.lv1.solved.high;

public class 키패드누르기 {
    private static final String leftValue = "L";
    private static final String rightValue = "R";

    public static void main(String[] args) {
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";
        System.out.println(solution(numbers,hand));
    }

    private static String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;

        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            if(number == 0) number = 11;

            if(number == 1 || number == 4 || number == 7) {
                answer.append(leftValue);
                left = number;
            } else if(number == 3 || number == 6 || number == 9) {
                answer.append(rightValue);
                right = number;
            } else {
                int leftDistance = Math.abs((left - number) / 3) + Math.abs((left - number) % 3);
                int rightDistance = Math.abs((right - number) / 3) + Math.abs((right - number) % 3);

                if(leftDistance < rightDistance) {
                    answer.append(leftValue);
                    left = number;
                } else if(leftDistance > rightDistance) {
                    answer.append(rightValue);
                    right = number;
                } else {
                    if(hand.equals("right")) {
                        answer.append(rightValue);
                        right = number;
                    } else {
                        answer.append(leftValue);
                        left = number;
                    }
                }
            }

        }
        return answer.toString();
    }
}
