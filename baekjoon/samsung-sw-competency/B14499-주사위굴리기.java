import java.awt.*;
import java.util.*;
import java.io.*;


// 주사위를 1차원 배열에 할당하고 이동 시마다 각 자리를 옮겨준다.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]); // 주사위 시작 x
        int y = Integer.parseInt(input[3]); // 주사위 시작 y
        int K = Integer.parseInt(input[4]);

        int[][] map = new int[N][M];
/*
  2
4 1 3
  5
  6
*/
        int[] dice = new int[7]; // dice

        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < input.length ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 바닥 시작점을 주사위에 찍는다.

        // K 개수만큼 명령 수행
        input = br.readLine().split(" ");
        for(int i = 0 ; i < K ; i++) {
            // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
            int tmp = dice[3];
            if(Integer.parseInt(input[i]) == 1) {
                if(y + 1 >= map[0].length) continue;
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                y = y + 1;
            }
            if(Integer.parseInt(input[i]) == 2) {
                if(y - 1 < 0) continue;
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                y = y - 1;
            }
            if(Integer.parseInt(input[i]) == 3) {
                if(x - 1 < 0) continue;
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                x = x - 1;
            }
            if(Integer.parseInt(input[i]) == 4) {
                if(x + 1 >= map.length) continue;
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                x = x + 1;
            }
            if(map[x][y] == 0) {
                map[x][y] = dice[6];
            } else {
                dice[6] = map[x][y];
                map[x][y] =0;
            }

            // 맨 위 출력
            bw.write(dice[3] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

