import java.util.*;
//https://www.acmicpc.net/problem/2581
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int sum = 0, min = Integer.MAX_VALUE;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i = a ; i <= b ; i++) {
            if(i >= 2) {
                int j;
                for(j = 2 ; j <= i / 2 ; j++) {
                    if(i % j == 0) {
                        break;
                    }
                }
                if(j > i / 2) {
                    sum += i;
                    if(i < min) {
                        min = i;
                    }
                }
            }
        }
        if(sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
        scanner.close();
    }
}
