import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Pair[] list = new Pair[n];
        for(int i = 0 ; i < n ; i++) {
            String[] input = br.readLine().split(" ");
            list[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(list, (e1, e2) -> {
            if(e1.y == e2.y) return e1.x - e2.x;
            return e1.y - e2.y;
        });
        int count = 0;
        int prev = -1;
        for(int i = 0 ; i < n ; i++) {
            int start = list[i].x;
            int end = list[i].y;
            if(prev <= start) {
                count++;
                prev = end;
            }
        }
        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
