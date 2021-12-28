import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int count = 0;
        for(int num = 666 ; count < N ; num++) {
            char[] arr = String.valueOf(num).toCharArray();
            for(int i = 0 ; i < arr.length - 2 ; i++) {
                if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2] && arr[i] == '6') {
                    count++;
                    break;
                }
            }
            if(count >= N) {
                bw.write(String.valueOf(num));
                break;
            }
        }
        br.close();
        bw.close();
    }
}
