package programmers.lv1.solved.middle;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(solution(answers));
    }

    private static int[] solution(int[] answers) {

        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};

        int[] answer = new int[3];

        for(int i=0; i<answers.length; i++){
            System.out.println(i % supo2.length);
        }


        return null;
    }
}
