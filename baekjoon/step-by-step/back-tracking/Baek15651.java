import java.io.*;
import java.util.*;

//백트래킹
//출력할 결과를 매개변수로 저장
public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        solve(N,M,0, "");
        bw.flush();
        bw.close();
        br.close();
    }
    static void solve(int n, int m, int pos, String result) throws IOException {
        if(pos == m) {
            bw.write(result + "\n");
            return;
        }
        for(int i = 0 ; i < n ; i++) {
            solve(n,m,pos + 1, result + (i+1) + " ");
            //back tracking
        }
    }
}
