import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        int sum = 0;
        int prev = 0;
        for(int i = 0 ; i < N ; i++) {
            sum = sum + arr[i];
            prev += sum;
        }
        bw.write(prev + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
