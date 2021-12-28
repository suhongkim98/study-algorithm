import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            String inputNum = br.readLine();
            arr[i] = Integer.parseInt(inputNum);
        }
        Arrays.sort(arr);
        Arrays.stream(arr).forEach((num)->System.out.println(num));
        br.close();
    }
}
