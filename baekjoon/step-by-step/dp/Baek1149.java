import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //bottom-up dp, 선택 가능한 이전 row의 rgb 중 값이 낮은 것을 할당
        int[][] dp = new int[N][3]; // row 의 r g b

        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int g = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if(i == 0) {
                dp[i][0] = r;
                dp[i][1] = g;
                dp[i][2] = b;
            } else {
                dp[i][0] = r + (dp[i-1][1] > dp[i-1][2] ? dp[i-1][2] : dp[i-1][1]);
                dp[i][1] = g + (dp[i-1][0] > dp[i-1][2] ? dp[i-1][2] : dp[i-1][0]);
                dp[i][2] = b + (dp[i-1][0] > dp[i-1][1] ? dp[i-1][1] : dp[i-1][0]);
            }
        }
        Integer result = Arrays.stream(dp[N-1]).min().orElseGet(null);
        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
