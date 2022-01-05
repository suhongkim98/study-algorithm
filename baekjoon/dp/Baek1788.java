import java.io.*;
import java.util.Arrays;
//피보나치 확장
//dp
//양수는 top-down
//음수는 bottom-up
public class Main {
    static int[] dp = new int[1000001]; //절대값
    static int[] dp2 = new int[1000001]; //절대값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n < 0) {
            //음수는 bottom-up 방식으로 dp구현
            dp2[0] = 0;
            dp2[1] = 1;
            for(int i = 2 ; i <= -n ; i++) {
                dp2[i] = (dp2[i-2] - dp2[i-1]) % 1000000000;
            }
        }
        int result = solve(n);
        if(result > 0) System.out.println(1);
        else if(result == 0) System.out.println(0);
        else System.out.println(-1);
        System.out.println(Math.abs(result));
        bw.close();
        br.close();
    }
    static int solve(int n) {
        if(n < 0) return dp2[-n];
        if(n == 0) return dp[n] = 0;
        if(n == 1) return dp[1] = 1;
        if(dp[n] != 0) return dp[n];
        return dp[n] = (solve(n - 1) + solve(n - 2))  % 1000000000;
    }
}
