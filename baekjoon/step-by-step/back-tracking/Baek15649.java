import java.io.*;
import java.util.*;


//비트연산
//순열
//백트래킹
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        solve(N, M,0, 0, "");

        bw.flush();
        bw.close();
        br.close();
    }
    //순열
    static void solve(int n,int m, int count, int used, String val) {
        if(count == m) {
            //m개 선택 완료
            System.out.println(val);
            return;
        }
        for(int i = 0 ; i < n ; i++) {
            if((used & (1 << i)) != 0) continue; // 사용한 비트
            solve(n, m, count + 1, used | (1 << i), val + (i + 1) + " ");
        }
    }
}
