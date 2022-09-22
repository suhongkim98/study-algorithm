import java.awt.*;
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rooms = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < input.length ; i++) {
            rooms[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        int B = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        long result = 0;
        for(int i = 0 ; i < N ; i++) {
            // 총감독관
            result++;
            rooms[i] -= B;
            if(rooms[i] > 0) {
                // 부감독관
                result += Math.ceil((double)rooms[i] / C);
            }
        }
        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}

