import java.util.*;
//https://www.acmicpc.net/problem/11022
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        
        for(int i = 1 ; i <= size ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a+b));
            
        }
        scanner.close();
    }
}
