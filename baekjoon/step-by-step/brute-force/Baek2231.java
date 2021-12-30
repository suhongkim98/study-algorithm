import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int result = 0;
        for(int i = 0 ; i < N ; i++) {
            int tmp = i;
            int sum = tmp;
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum == N) {
                result = i;
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
