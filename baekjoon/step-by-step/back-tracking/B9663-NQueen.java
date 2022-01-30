import java.io.*;
import java.util.*;

//빽트래킹
//N-Queen문제
public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] row = new int[N];
        solve(row, N, 0);
        bw.write(count + "");

        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(int[] row, int N, int pos) {
        if(pos == N) {
            count++;
            return;
        }
        for(int i = 0 ; i < N ; i++) {
            // row 에는 한마리의 퀸만 존재 가능
            row[pos] = i + 1; // pos 번째 col 의 i번째 row 에 퀸 배치
            if(!promising(row, pos)) continue; // 퀸배치 불가
            solve(row, N, pos + 1);
        }
    }
    static boolean promising(int[] row, int pos) {
        for(int col = 0 ; col < pos ; col++) {
            if(row[col] == row[pos]) return false;
            if(Math.abs((pos + 1) - (col + 1)) == Math.abs(row[pos] - row[col])) return false;
        }
        return true;
    }
}
