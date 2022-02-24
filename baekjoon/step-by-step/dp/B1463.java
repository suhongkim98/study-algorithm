import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if(n == 1) System.out.println(0);
        else {
            System.out.println(solve(dp, n));
        }
        bw.flush();
        br.close();
        bw.close();
    }
    // 1 뺐을 때, 나누기 2 했을 떄, 나누기 3 했을 때 dp중 적은 값 할당
    static int solve(int[] dp, int n) {
        if(n == 2) return dp[n] = 1;
        if(n == 3) return dp[n] = 1;
        if(dp[n] != 0) return dp[n];
        int result = Integer.MAX_VALUE;
        if(n % 3 == 0) {
            int tmp = solve(dp, n / 3);
            if(tmp < result) result = tmp;
        }
        if(n % 2 == 0) {
            int tmp = solve(dp, n / 2);
            if(tmp < result) result = tmp;
        }
        int tmp = solve(dp, n - 1);
        if(tmp < result) result = tmp;
        return dp[n] = result + 1; // count 1
    }
}
