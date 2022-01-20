import java.io.*;
import java.util.*;

//dp bottom up
//현재 dp값을 자식에게 전파
//dp값중 최대값 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int result = 0;
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j <= i ; j++) {
                int n = Integer.parseInt(input[j]);
                // 현재 값을 자식에게 전파하는 bottom up 방식
                dp[i][j] = dp[i][j] + n; // 현재값에 n을 할당
                if(result < dp[i][j]) result = dp[i][j]; // 최대값 저장
                if(i + 1 < N) {
                    //오른쪽 자식에게 값 할당, 비교문 필요 없음
                    dp[i + 1][j + 1] = dp[i][j];
                    //왼쪽 자식에게 값 할당, 비교문 필요
                    if(dp[i + 1][j] < dp[i][j]) dp[i + 1][j] = dp[i][j];
                }
            }
        }
        bw.write(result + " ");
        bw.flush();
        br.close();
        bw.close();
    }
}
