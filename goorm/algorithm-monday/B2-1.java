import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int sum = 0;
            for(int j = 0 ; j < n ; j++) {
                sum += Integer.parseInt(input[j]);
            }
            float avg = sum / (float)n;
            int count = 0;
            for(int j = 0 ; j < n ; j++) {
                if(Integer.parseInt(input[j]) >= avg) count++;
            }
            bw.write(count + "/" + n + "\n");
        }


        br.close();
        bw.close();
    }
}

/*


 */
