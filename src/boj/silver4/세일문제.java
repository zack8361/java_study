package boj.silver4;

import javax.swing.event.MenuKeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * KSG 편의점에서는 과일우유, 드링킹요구르트 등의 유제품을 '2+1 세일'하는 행사를 하고 있습니다. KSG 편의점에서 유제품 3개를 한 번에 산다면 그중에서 가장 싼 것은 무료로 지불하고 나머지 두 개의 제품 가격만 지불하면 됩니다. 한 번에 3개의 유제품을 사지 않는다면 할인 없이 정가를 지불해야 합니다.
 * <p>
 * 예를 들어, 7개의 유제품이 있어서 각 제품의 가격이 10, 9, 4, 2, 6, 4, 3이고 재현이가 (10, 3, 2), (4, 6, 4), (9)로 총 3번에 걸쳐서 물건을 산다면 첫 번째 꾸러미에서는 13원을, 두 번째 꾸러미에서는 10원을, 세 번째 꾸러미에서는 9원을 지불해야 합니다.
 * <p>
 * 재현이는 KSG 편의점에서 친구들과 같이 먹을 총 N팩의 유제품을 구입하려고 합니다. 재현이를 도와 최소비용으로 유제품을 구입할 수 있도록 도와주세요!
 * <p>
 * 입력
 * 첫 번째 줄에는 유제품의 수 N (1 ≤ N ≤ 100,000)이 주어집니다.
 * <p>
 * 두 번째 줄부터 N개의 줄에는 각 유제품의 가격 Ci (1 ≤ Ci ≤ 100,000)가 주어집니다.
 * <p>
 * 4
 * 3
 * 2
 * 3
 * 2
 */
public class 세일문제 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr= new int[n];

        int[] arr = new int[]{6, 4, 5, 5, 5, 5, 5};

        int answer = 0;

        for (int i = 0; i < arr.length; i += 3) {
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j < i + 3; j++) {
                try {
                    list.add(arr[j]);
                } catch (Exception e) {
                    continue;
                }
            }
            Collections.sort(list);
            if (list.size() == 3) {
                sum += list.get(2) + list.get(1);
            } else {
                for (Integer integer : list) {
                    sum += integer;
                }
            }
            answer += sum;
        }
        System.out.println(answer);

    }
}