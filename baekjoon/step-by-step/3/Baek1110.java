import java.util.*;
//https://www.acmicpc.net/problem/1110
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int num = start;
        int count = 0;
        do{
            if(num < 10) {
                num = num + num * 10;
            } else {
                int a = num / 10;
                int b = num % 10;
                num = b * 10 + ((a + b) % 10);
            }
            count++;
        }while(num != start);
        System.out.println(count);
        scanner.close();
    }
}
