import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(!q.isEmpty()) bw.write(q.poll() + "\n");
                else bw.write("0\n");
            } else {
                q.add(n);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
