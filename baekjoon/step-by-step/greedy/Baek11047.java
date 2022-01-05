import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int value = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            if(value < arr[i]) continue;
            count += value / arr[i];
            value = value % arr[i];
        }
        bw.write(count + "");
        bw.flush();

        bw.close();
        br.close();
    }
}
