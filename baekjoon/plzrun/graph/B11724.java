import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N + 1][N + 1]; // 시작은 1
        boolean[] visit = new boolean[N + 1];
        for(int i = 0 ; i < M ; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }

        int count = 0;
        for(int i = 1 ; i < N + 1 ; i++) {
            // 방문정보 공유함
            if(!visit[i]) {
                count++;
                dfs(map, visit, i);
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int[][] map, boolean[] visit, int n) {
        visit[n] = true;
        for(int i = 0 ; i < map[n].length ; i++) {
            if(map[n][i] != 0 && !visit[i]) {
                dfs(map, visit, i);
            }
        }
    }

}

