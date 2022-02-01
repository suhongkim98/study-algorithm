import java.io.*;
import java.util.*;

// dp top-down으로 해결
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2]; // 해당 index 에서 0은 1단 점프 기회가 없었을 때, 1은 1단점프 가능할 때
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        bw.write(solve(dp, arr, N - 1, 1) + "");

        bw.flush();
        br.close();
        bw.close();
    }
    static int solve(int[][] dp, int[] arr, int index, int opportunity) {
        if(dp[index][opportunity] != 0) return dp[index][opportunity];
        if(index == 0) return dp[index][opportunity] = arr[index];
        if(index == 1 && opportunity == 1) return dp[index][opportunity] = arr[index] + arr[index - 1];
        else if(index == 1) return dp[index][opportunity] = arr[index];

        if(opportunity == 0) return dp[index][opportunity] = arr[index] + solve(dp, arr, index - 2, 1); // 1단 점프 기회가 없다면 무조건 2단점프
        return dp[index][1] = arr[index] + Math.max(solve(dp, arr, index - 1, 0), solve(dp, arr, index - 2, 1)); // 1단점프, 2단점프 중 큰 값
    }
}

