import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        boolean[] visit = new boolean[n + 1];
        for(int i = 0 ; i < v ; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(map, visit, 1);
        System.out.println(count - 1);
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int[][] map, boolean[] visit, int index) {
        visit[index] = true;
        count++;
        for(int i = 0 ; i < map[0].length ; i++) {
            if(map[index][i] != 0 && !visit[i]) {
                visit[i] = true;
                dfs(map, visit, i);
            }
        }
    }
}

