package boj.silver2;

public class 이분탐색 {
    public static void main(String[] args) {
        int left = 1;
        int right = 1000;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isCondition(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);

    }

    private static boolean isCondition(int mid){
        if(mid > 500){
            return true;
        }
        return false;
    }
}
