import java.io.*;
import java.util.*;

//순열 백트래킹 비트연산
public class Main {
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        result = new int[M];

        solve(N, M,0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
    //순열
    static void solve(int n,int m, int pos, int used) {
        if(pos == m) {
            //m개 선택 완료
            for(int i = 0 ; i < m ; i++) {
                System.out.print((result[i]+1) + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0 ; i < n ; i++) {
            if((used & (1 << i)) != 0) continue; // 사용한 비트 패스
            result[pos] = i;
            solve(n, m, pos + 1, used | (1 << i));
        }
    }
}
