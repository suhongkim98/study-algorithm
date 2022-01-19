import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(q.size() <= 0) bw.write("0\n");
                else bw.write(q.poll() + "\n");
            } else {
                q.add(n);
            }
        }

        bw.close();
        br.close();
    }
}
