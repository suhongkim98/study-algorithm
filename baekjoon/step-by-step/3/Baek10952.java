import java.util.*;
//https://www.acmicpc.net/problem/10952
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a + b == 0) {
                break;
            }
            System.out.println(a + b);
        }
        scanner.close();
    }
}
