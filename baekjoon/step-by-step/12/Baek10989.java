import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int[] counting = new int[10001];
        for(int i = 0 ; i < N ; i++) {
            String inputNum = br.readLine();
            counting[Integer.parseInt(inputNum)]++;
        }

        for(int i = 0 ; i < 10001 ; i++) {
            if(counting[i] != 0) {
                for(int j = 0 ; j < counting[i] ; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
