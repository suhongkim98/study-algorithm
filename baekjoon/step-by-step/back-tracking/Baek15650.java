import java.io.*;
import java.util.*;

//백트래킹
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        solve(N,M,0,0, "");

        bw.flush();
        bw.close();
        br.close();
    }
    static void solve(int n, int m, int pos, int count, String val) {
        if(count == m) {
            System.out.println(val);
            return;
        }
        for(int i = pos ; i < n ; i++) {
            solve(n, m, i + 1, count + 1, val + (i + 1) + " ");
        }
    }
}
