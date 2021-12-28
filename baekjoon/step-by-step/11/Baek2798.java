import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                for(int k = j+1 ; k < N ; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum > M) continue;
                    if(sum > max) max = sum;
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
