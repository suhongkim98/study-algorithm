import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(br.readLine());

        if(C / 60 > 0) {
            A += C / 60;
            C = C % 60;
        }
        B += C;
        if(B / 60 > 0) {
            A += B / 60;
            B = B % 60;
        }
        bw.write((A % 24) + " " + B);

        br.close();
        bw.close();
    }
}

