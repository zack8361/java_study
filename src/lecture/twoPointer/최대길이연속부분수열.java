package lecture.twoPointer;

public class 최대길이연속부분수열 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1,0,1,1,0,1,1,0,1};
        int k = 2;
        int left = 0;
        int right = 0;
        int cnt = 0;

        int answer = 0;

        while (right < arr.length) {
            if (arr[right] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[left] == 0) {
                    cnt--;
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        System.out.println(answer);
    }
}
