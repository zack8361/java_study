package programmers.bfs;

import java.util.Arrays;

public class 아이템줍기 {
    public static void main(String[] args) {

        int[][] rectangles = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };

        int characterX = 1;
        int characterY = 3;

        int itemX = 7;
        int itemY = 8;

        int[][] maps = new int[102][102];

        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0] * 2;
            int y1 = rectangle[1] * 2;
            int x2 = rectangle[2] * 2;
            int y2 = rectangle[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {

                    // 내부는 2로 막기
                    if (x > x1 && x < x2 && y > y1 && y < y2) {
                        maps[y][x] = 2;
                    }

                    else {
                        if (maps[y][x] != 2) {
                            maps[y][x] = 1;
                        }
                    }
                }
            }
        }

        for (int y = 20; y >= 0; y--) {
            for (int x = 0; x <= 20; x++) {
                if (maps[y][x] == 0) System.out.print("⬜");
                else if (maps[y][x] == 1) System.out.print("🟩");
                else System.out.print("🟥");
            }
            System.out.println(" y=" + y);
        }
    }
}