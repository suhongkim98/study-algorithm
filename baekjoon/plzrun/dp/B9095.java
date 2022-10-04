import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        for(int i = 0 ; i < N ; i++) {
            bw.write(solve(dp, Integer.parseInt(br.readLine())) + "\n");
        }

        br.close();
        bw.close();
    }
    // 방정식: f(n) = f(n - 1) + f(n - 2) + f(n -3)
    static int solve(int[] dp, int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        if(dp[n] > 0) return dp[n];
        return dp[n] = solve(dp, n - 1) + solve(dp, n - 2) + solve(dp, n - 3);
    }
}

