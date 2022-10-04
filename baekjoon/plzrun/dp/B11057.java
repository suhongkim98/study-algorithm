import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 자리수가 하나씩 늘어날 때마다 끝자리만 생각해보자
         * 방정식: dp[a][b] = dp[a - 1][0] ~ dp[a - 1][9]까지의 합
         * sum = dp[N][0] ~ dp[N][9]
         * sum 이 답임
         */
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10]; // 자리수 N, 끝자리 경우의 수(0~9)
        for(int i = 0 ; i < 10 ; i++) {
            dp[1][i] = 1; // 1 자리수 일때는 각 자리수의 경우의 수는 1임
        }

        int sum = 0;
        for(int i = 0 ; i < 10 ; i++) {
            sum += solve(dp, N, i);
        }
        bw.write((sum % 10007) + "");

        br.close();
        bw.close();
    }
    static int solve(int[][] dp, int index, int last) {
        if(dp[index][last] != 0) return dp[index][last];
        int sum = 0;
        for(int i = 0 ; i <= last ; i++) {
            sum += solve(dp, index - 1, i) % 10007;
        }
        return dp[index][last] = sum % 10007;
    }
}

