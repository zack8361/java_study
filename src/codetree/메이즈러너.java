package codetree;

import java.util.*;

public class 메이즈러너 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int cnt = 0;
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[N][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            arr[x][y] = 10;
        }

        int exitX = sc.nextInt()-1;
        int exitY = sc.nextInt()-1;
        arr[exitX][exitY] = -1;


        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("--------------------------------------");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 사람을 찾았을때
                if (arr[i][j] == 10) {
                    bfs(i,j, exitX, exitY);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void bfs(int x, int y, int exitX, int exitY) {
        int distance = Math.abs(exitX - x) + Math.abs(exitY - y);
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            int currentDistance = Math.abs(exitX - nx) + Math.abs(exitY - ny);
            // 출구까지의 거리가 더짧으면 예외, 배열을 벗어나면 예외.
            if(currentDistance > distance) continue;
            if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
            if(arr[nx][ny] != 0) continue;

            minDistance = Math.min(minDistance, currentDistance);
            arr[x][y] = 0;
            cnt ++;
            if(arr[nx][ny] != -1) {
                arr[nx][ny] = 10;
            }
        }
        int[] sqaure = findSqaure();
        System.out.println(Arrays.toString(sqaure));

//        switchSqaure();

    }

    private static int[] findSqaure() {

        for(int size = 2; size <= arr.length; size ++ ) {
            for(int i = 0; i <= arr.length - size; i++) {
                for (int j = 0; j <= arr.length - size; j++) {
                    boolean personFlag = false;
                    boolean exitFlag = false;
                    for (int x = i; x < i + size; x++) {
                        for (int y = j; y < j + size; y++) {
                            if(arr[x][y] == 10) personFlag = true;
                            if(arr[x][y] == -1) exitFlag = true;
                            System.out.print(arr[x][y] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("---------------------");
                    if(personFlag && exitFlag) {
                        System.out.println("찾았다");
                        return new int[]{i,j,size};
                    }
                }
            }
        }
        return null;
    }

}