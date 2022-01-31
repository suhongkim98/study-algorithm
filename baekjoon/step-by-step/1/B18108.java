import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int y = Integer.parseInt(br.readLine());
        bw.write((y - 543) + "");

        bw.flush();
        br.close();
        bw.close();
    }
}

