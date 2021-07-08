import java.util.*;
//https://www.acmicpc.net/problem/1978
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int count = 0;
        for(int i = 0 ; i < size ; i++) {
            int n = scanner.nextInt();
            if(n >= 2) {
                int j;
                for(j = 2 ; j <= n / 2 ; j++) {
                    if(n % j == 0) {
                        break;
                    }
                }
                if(j > n / 2) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
