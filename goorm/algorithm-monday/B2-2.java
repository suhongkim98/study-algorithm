import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char before = input.charAt(0);
        int count = 1;
        for(int i = 1 ; i < input.length() ; i++) {
            if(input.charAt(i) != before) {
                count++;
                before = input.charAt(i);
            }
        }
        bw.write(count + "");

        br.close();
        bw.close();
    }
}

/*


 */
