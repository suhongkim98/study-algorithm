import java.io.*;
import java.util.*;

// B11727
/*
dp 점화식을 세운다.
n타일을 깔때는 n-1 타일에 2x1타일을 붙여주기 + n-2타일에 1x2타일을 붙이거나 2x2타일을 붙여주면 되므로
점화식은 n이 3부터, n-1 + n-2*2
 */
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[1001];
        int n = Integer.parseInt(br.readLine());
        bw.write(solve(dp, n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(int[] dp, int n) {
        if(dp[n] > 0) return dp[n];
        if(n == 1) return dp[n] = 1;
        if(n == 2) return dp[n] = 3;
        return dp[n] = (solve(dp, n-1) + solve(dp,n-2) * 2) % 10007;
    }
}

