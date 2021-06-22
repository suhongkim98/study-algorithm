import java.util.*;
//https://www.acmicpc.net/problem/10871
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        
        for(int i = 0 ; i < size ; i++) {
            int input = scanner.nextInt();
            if(input < n) {
                System.out.print(input + " ");
            }
        }
        scanner.close();
    }
}
