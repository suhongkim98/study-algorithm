import java.util.*;
//https://www.acmicpc.net/problem/2775
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0 ; i < T ; i++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(getSum(k,n));
        }
        scanner.close();
    }
    static int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 1) return 1;
        return getSum(a, b-1) + getSum(a-1, b);
    }
}
