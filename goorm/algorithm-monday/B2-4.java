import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] map = new int[N][N];

        int count = 0;
        int[] dx = {0,0,1,-1,0};
        int[] dy = {1,-1,0,0,0}; // 원점까지해서 5개
        for(int i = 0 ; i < K ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < 5 ; j++) {
                int newX = Integer.parseInt(input[0]) - 1 + dx[j];
                int newY = Integer.parseInt(input[1]) - 1 + dy[j];
                if(newX < 0 || newX >= map.length) continue;
                if(newY < 0 || newY >= map[0].length) continue;
                count++;
            }
        }
        bw.write(count + "");


        br.close();
        bw.close();
    }
}
