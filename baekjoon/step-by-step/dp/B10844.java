import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[101][10]; // n, 마지막 숫자
        dp[1][0] = 0;
        for(int i = 1; i < 10 ; i++ ){
            dp[1][i] = 1;
        }
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0 ; i < 10 ; i++) {
            sum = (sum + solve(dp, n, i)) % 1000000000;
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
    static int solve(int[][] dp, int n, int last) {
        if(n == 1) return dp[1][last];
        if(dp[n][last] != 0) return dp[n][last];
        if(last == 0) {
            return dp[n][0] = solve(dp, n - 1, 1);
        }
        if(last == 9) {
            return dp[n][9] = solve(dp, n - 1, 8);
        }
        return dp[n][last] = (solve(dp, n - 1, last - 1)% 1000000000) + (solve(dp, n - 1, last + 1)% 1000000000);
    }
}

