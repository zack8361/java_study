package lecture.twoPointer;

public class 최대매출 {
    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        int[] arr = {12, 15 , 11, 20, 25, 10, 20, 19, 13, 15};

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += arr[i];
        }

        for(int i = 3; i< n; i++) {
            sum += arr[i] - arr[i - k];
            System.out.println(sum);
        }

    }
}
