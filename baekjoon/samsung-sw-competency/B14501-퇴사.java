import java.awt.*;
import java.util.*;
import java.io.*;

/*
조합문제
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        dfs(T, P, 0, 0, 0);
        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static int max = -1;
    static void dfs(int[] T, int[] P, int cur, int delay, int score) {
        if(T.length <= cur) {
            if(max < score) max = score;
            return;
        }
        // 선택할 수 있으면 선택
        if(delay <= 0 && cur + T[cur] <= T.length) {
            dfs(T, P, cur + 1, delay + T[cur] - 1, score + P[cur]);
        }
        // 선택안하고 다음으로 넘김
        dfs(T, P, cur + 1, delay - 1 >= 0 ? delay - 1 : 0, score); // 딜레이 감소
    }
}

