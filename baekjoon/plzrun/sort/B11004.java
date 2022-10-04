import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        bw.write(arr[K - 1] + "");
        br.close();
        bw.close();
    }
}