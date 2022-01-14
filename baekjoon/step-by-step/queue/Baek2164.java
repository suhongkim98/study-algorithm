import java.io.*;
import java.util.*;

//Queue
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) {
            q.add(i);
        }
        while (q.size() > 1) {
            q.poll();
            if(q.size() <= 1) break;
            Integer n = q.poll();
            q.add(n);
        }
        bw.write(q.poll() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
