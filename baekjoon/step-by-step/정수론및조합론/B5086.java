import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            if(n == m && n == 0) break;
            if(n > m && n % m == 0) {
                bw.write("multiple\n");
                continue;
            }
            if(n < m && m % n == 0) {
                bw.write("factor\n");
                continue;
            }
            bw.write("neither\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

