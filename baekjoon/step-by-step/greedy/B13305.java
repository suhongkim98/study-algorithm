import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        long[] weight = new long[size - 1];
        long[] price = new long[size];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < size - 1 ; i++) {
            weight[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i = 0 ; i < size ; i++) {
            price[i] = Integer.parseInt(input[i]);
        }
        long total = 0;
        long prev = price[0];
        long move = 0;
        for(int i = 0 ; i < size - 1 ; i++) {
            if(prev <= price[i]) {
                move += weight[i];
            } else {
                total += move * prev;
                prev = price[i];
                move = weight[i];
            }
        }
        total += move * prev;


        bw.write(total+"");
        bw.flush();
        br.close();
        bw.close();
    }
}

