import java.io.*;
import java.util.*;

class Main {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        boolean[] visit = new boolean[N];
        solve(map,visit,0,0);
        bw.write(result+"");
        bw.close();
        br.close();
    }
    static void solve(int[][] map,boolean[] visit, int pos, int count) {
        if(count == map.length / 2) {
            int team1 = 0;
            int team2 = 0;
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = 0 ; j < map.length ; j++) {
                    if(i == j) continue;
                    if(visit[i] == visit[j]) {
                        if(visit[i]) {
                            team1 += map[i][j];
                        } else {
                            team2 += map[i][j];
                        }
                    }
                }
            }
            if(Math.abs(team1 - team2) < result) result = Math.abs(team1 - team2);
            return;
        }
        if(pos >= map.length) return;
        //조합
        visit[pos] = true;
        solve(map,visit, pos + 1, count + 1); // 현재 선택
        visit[pos] = false; // 백트래킹
        solve(map,visit, pos + 1, count); // 현재 선택안함
    }
}

