import java.io.*;
import java.util.*;

//요세푸스 순열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) {
            list.add(i);
        }
        bw.write("<");
        int index = 0;
        for(int i = 0 ; i < N ; i++) {
            int n = list.remove(index = (index + K - 1) % list.size());
            if(i == 0) bw.write(n + "");
            else bw.write(", " + n);
        }
        bw.write(">");

        bw.flush();
        br.close();
        bw.close();
    }
}

