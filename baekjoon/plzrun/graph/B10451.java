import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            // dfs로 카운트를 돌린다.
            boolean[] visit = new boolean[input.length];
            int count = 0;
            for(int j = 0 ; j < input.length ; j++) {
                if(!visit[j]) {
                    count++;
                    visit[j] = true;
                    dfs(visit, input, j, Integer.parseInt(input[j]) - 1);
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    // dfs를 돌려 start와 next가 일치하면 break
    static void dfs(boolean[] visit, String[] input, int start, int next) {
        visit[next] = true;
        if(start == next) return;
        dfs(visit, input, start, Integer.parseInt(input[next]) - 1);
    }
}

