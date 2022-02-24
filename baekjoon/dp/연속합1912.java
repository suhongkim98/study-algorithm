import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int ret;
        String[] input = br.readLine().split(" ");
        dp[0] = ret = Integer.parseInt(input[0]);
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + Integer.parseInt(input[i]), Integer.parseInt(input[i]));
            ret = Math.max(dp[i], ret);
        }
        System.out.println(ret);

        bw.flush();
        br.close();
        bw.close();
    }
}
