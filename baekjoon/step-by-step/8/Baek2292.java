import java.util.*;
//https://www.acmicpc.net/problem/2292
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 1) {
            System.out.println(1);
        } else {
            int index = 1;
            int start = 2;
            int gap = 6;
            while(true) {
                int end = start + index * gap - 1;
                if(n >= start && n <= end) break;
                
                start += index * gap;
                index++;
            }
            System.out.println(index + 1);
        }
        scanner.close();
    }
}
