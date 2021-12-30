import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        Pair[] list = new Pair[N];
        int[] rank = new int[N];

        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            list[i] = new Pair();
            list[i].x = x;
            list[i].y = y;
            rank[i] = 1;
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(list[i].x < list[j].x && list[i].y < list[j].y) {
                    rank[i]++;
                }
            }
        }
        for(int i = 0 ; i < N ; i++) {
            bw.write(rank[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class Pair {
    int x;
    int y;
}
