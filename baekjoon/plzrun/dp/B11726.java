import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[1001];
        int num = Integer.parseInt(br.readLine());

        bw.write(solve(dp, num) +"");

        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(int[] dp, int n) {
        if(dp[n] != 0) return dp[n];
        if(n <= 2) return dp[n] = n;
        return dp[n] = (solve(dp, n - 1) + solve(dp, n - 2)) % 10007;
    }
}

