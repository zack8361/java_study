package lecture.binarysearch;

import java.util.Arrays;

public class 이분탐색기초 {
    public static void main(String[] args) {
        int[] arr = {23,87,65,12,57,32,99,81};

        int answer = 32;
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int lt = 0, rt =  arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == answer) {
                System.out.println(mid + 1);
                break;
            } else if (arr[mid] > answer) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

    }
}
