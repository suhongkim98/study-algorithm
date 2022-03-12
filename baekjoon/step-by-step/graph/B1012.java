import java.io.*;
import java.util.*;

class Main {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testcase ; i++) {
            count = 0;
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);
            int[][] map = new int[M][N];

            for(int j = 0 ; j < K ; j++) {
                String[] point = br.readLine().split(" ");
                int a = Integer.parseInt(point[0]);
                int b = Integer.parseInt(point[1]);
                map[a][b] = 1;
            }

            boolean[][] visit = new boolean[M][N];
            for(int a = 0 ; a < M ; a++) {
                for(int b = 0 ; b < N ; b++) {
                    if(map[a][b] != 0 && !visit[a][b]) {
                        count++;
                        dfs(map, visit, a, b);
                    }
                }
            }
            bw.write(count + "\n");
        }

        bw.close();
        br.close();
    }
    static int count = 0;
    static void dfs(int[][] map, boolean[][] visit, int a, int b) {
        visit[a][b] = true;

        // 4방면 탐색
        int[] dirX = {1,-1,0,0};
        int[] dirY = {0,0,1,-1};
        for(int i = 0 ; i < 4 ; i++) {
            int newX = a + dirX[i];
            int newY = b + dirY[i];
            if(newX < 0 || newX >= map.length) continue;
            if(newY < 0 || newY >= map[0].length) continue;
            if(map[newX][newY] != 0 && !visit[newX][newY]) dfs(map,visit,newX, newY);
        }
    }
}

