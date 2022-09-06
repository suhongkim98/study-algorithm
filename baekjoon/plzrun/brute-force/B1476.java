import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int e = 1, s = 1, m = 1;
        long start = 1;
        while (true) {
            if(E == e && S == s && M == m) break;

            e++; s++; m++; start++;
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
        }
        bw.write(start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}


