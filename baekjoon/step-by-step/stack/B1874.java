import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int target = 0;
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(br.readLine());
            while(target < n) {
                sb.append("+\n");
                target++;
                s.push(target);
            }
            if(s.isEmpty()) break;
            if(s.peek() == n) {
                sb.append("-\n");
                s.pop();
            }
        }
        if(s.size() == 0 && target == N) bw.write(sb.toString());
        else bw.write("NO");
        bw.flush();
        br.close();
        bw.close();
    }
}

