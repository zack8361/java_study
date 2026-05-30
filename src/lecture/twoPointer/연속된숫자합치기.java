package lecture.twoPointer;

public class 연속된숫자합치기 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        int n = 17;
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum >= n) {
                sum -= arr[i];
                cnt ++;
                sum = arr[i];
            }
        }
    }
}
