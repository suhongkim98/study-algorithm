import java.io.*;
import java.util.*;

//백트래킹
public class Main {
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] result = new int[M];
        solve(result, N, M,0,0);


        bw.flush();
        br.close();
        bw.close();
    }
    static void solve(int[] result, int N, int M, int pos, int count) {
        if(count == M) {
            for(int i = 0 ; i < M ; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = pos ; i < N ; i++) {
            result[count] = i + 1;
            solve(result, N, M, i,count + 1);
        }
    }
}
