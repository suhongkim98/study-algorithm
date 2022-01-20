import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            int count = 0;
            for(int j = 0 ; j < input.length() ; j++) {
                if(input.charAt(j) == '(') {
                    count++;
                } else {
                    count--;
                    if(count < 0) break;
                }
            }
            if(count != 0) bw.write("NO\n");
            else bw.write("YES\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
