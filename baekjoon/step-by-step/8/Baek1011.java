import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1011
public class Main{
    public static void main(String []args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < size ; i++) {
            String[] input = bf.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int des = b - a;
            int max = (int)Math.sqrt(des);
            if(max == Math.sqrt(des)) {
				System.out.println(max * 2 - 1);
			}
			else if(des <= max * max + max) {
				System.out.println(max * 2);
			}
			else {
				System.out.println(max * 2 + 1);
			}
        }
        bf.close();
    }
}
