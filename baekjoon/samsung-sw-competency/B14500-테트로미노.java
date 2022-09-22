import java.awt.*;
import java.util.*;
import java.io.*;


/*
테트로미노
 엿 모양을 제외한 나머지 도형은 길이가 4인 4방면 탐색으로 dfs로 처리
 엿 모양은 별도로 처리한다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                dfs(visit, map, 0,0, i, j);
                checkFucked(map, i, j); // 엿모양 도형 검사
            }
        }
        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static int max = 0;
    // 길이가 4개인 도형 탐색
    static void dfs(boolean[][] visit, int[][] map, int count, int cur, int x, int y) {
        if(count >= 4) {
            // 최대값 계산
            if(max < cur) max = cur;
            return;
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for(int i = 0 ; i < 4 ; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newX >= map.length) continue;
            if(newY < 0 || newY >= map[0].length) continue;
            if(visit[newX][newY]) continue;

            visit[newX][newY] = true;
            dfs(visit,map, count + 1, cur + map[newX][newY], newX,newY);
            visit[newX][newY] = false; // 백트래킹해야 나중에 또 방문가능
        }
    }

    // 엿모양 도형을 별도로 체크한다.
    static void checkFucked(int[][] map, int x, int y) {
        // 현재 x, y에서 d값을 더함
        int[] dx1 = {0,0,0,0};
        int[] dx2 = {0,1,0,1};
        int[] dx3 = {0,2,0,2};
        int[] dx4 = {1,1,-1,1};
        int[] dy1 = {0,0,0,0};
        int[] dy2 = {1,0,1,0};
        int[] dy3 = {2,0,2,0};
        int[] dy4 = {1,1,1,-1};

        for(int i = 0 ; i < 4 ; i++) {
            // 4개의 도형에 대해 각각 좌표
            int newX1 = dx1[i] + x;
            int newX2 = dx2[i] + x;
            int newX3 = dx3[i] + x;
            int newX4 = dx4[i] + x;

            int newY1 = dy1[i] + y;
            int newY2 = dy2[i] + y;
            int newY3 = dy3[i] + y;
            int newY4 = dy4[i] + y;


            if(newX1 < 0 || newY1 < 0 || newX1 >= map.length || newY1 >= map[0].length) continue;
            if(newX2 < 0 || newY2 < 0 || newX2 >= map.length || newY2 >= map[0].length) continue;
            if(newX3 < 0 || newY3 < 0 || newX3 >= map.length || newY3 >= map[0].length) continue;
            if(newX4 < 0 || newY4 < 0 || newX4 >= map.length || newY4 >= map[0].length) continue;


            int result = map[newX1][newY1] + map[newX2][newY2] + map[newX3][newY3] + map[newX4][newY4];

            if(max < result) max = result;
        }
    }
}

