import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Integer[] dp = new Integer[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        max = solve(arr, dp, N - 1);
        bw.write(max+"");
        bw.close();
        br.close();
    }
    static int solve(int[] arr, Integer[] dp, int n) {
        if(n < 0) return 0;
        if(dp[n] != null) return dp[n];
        if(n == 0) return dp[0] = arr[0]; // n = 1개
        if(n == 1) return dp[1] = arr[0] + arr[1]; // n = 2개
        // 3개부터 dp, n = 3부터 선택가능한 경우의 수가 3개 있음
        int case1 = solve(arr, dp, n - 1); // 새로추가된 현재를 선택안하는 경우
        int case2 = arr[n] + solve(arr,dp, n - 2); // 현재 선택, 이전 것을 선택하지 않고 그 전 dp를 선택
        int case3 = arr[n] + arr[n - 1] + solve(arr, dp, n - 3); // 현재, 전것 선택 후 뛰기
        return dp[n] = Math.max(Math.max(case1, case2), case3); // 경우의 수 중 최대값
    }
}

