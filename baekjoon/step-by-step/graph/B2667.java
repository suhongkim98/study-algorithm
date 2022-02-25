import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        List<Integer> counts = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            String input = br.readLine();
            for(int j = 0 ; j < n ; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++) {
                if(map[i][j] != 0 && !visit[i][j]) {
                    totalCount++;
                    count = 0;
                    dfs(map,visit,i,j);
                    counts.add(count);
                }
            }
        }
        counts.sort((e1, e2)->{
            return e1 - e2;
        });
        System.out.println(totalCount);
        for(int i = 0 ; i < counts.size() ; i++) {
            System.out.println(counts.get(i));
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static int totalCount = 0;
    static int count = 0;
    static void dfs(int[][] map,boolean[][] visit, int i, int j) {
        visit[i][j] = true;
        count++;
        if(j + 1 < map[0].length && map[i][j+1] == 1 && !visit[i][j + 1]) dfs(map,visit,i,j+1);
        if(j - 1 >= 0 && map[i][j-1] == 1 && !visit[i][j - 1]) dfs(map,visit,i,j-1);
        if(i + 1 < map[0].length && map[i + 1][j] == 1 && !visit[i + 1][j]) dfs(map,visit,i+1,j);
        if(i - 1 >= 0 && map[i-1][j] == 1 && !visit[i-1][j]) dfs(map,visit,i-1,j);
    }
}

