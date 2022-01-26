import java.io.*;
import java.util.*;

public class Main {
    static int[] count = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        solve(map, 0, 0, N);
        bw.write(count[0] + "\n");
        bw.write(count[1] + "\n");
        bw.write(count[2] + "");

        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(int[][] map, int startX, int startY, int size) {
        boolean flag = false;
        int standard = map[startX][startY];
        // 분할조건
        for(int i = startX ; i < startX + size ; i++) {
            for(int j = startY ; j < startY + size ; j++) {
                if(map[i][j] != standard) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        if(flag) {
            int newSize = size / 3;
            solve(map, startX, startY, newSize);
            solve(map, startX, startY + newSize, newSize);
            solve(map, startX, startY + newSize * 2, newSize);

            solve(map, startX + newSize, startY, newSize);
            solve(map, startX + newSize, startY + newSize, newSize);
            solve(map, startX + newSize, startY + newSize * 2, newSize);

            solve(map, startX + newSize * 2, startY, newSize);
            solve(map, startX + newSize * 2, startY + newSize, newSize);
            solve(map, startX + newSize * 2, startY + newSize * 2, newSize);

        } else {
            // 카운트 새기
            count[standard + 1]++;
        }
    }
}
