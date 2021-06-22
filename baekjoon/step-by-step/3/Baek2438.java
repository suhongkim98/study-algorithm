import java.util.*;
//https://www.acmicpc.net/problem/2438
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j<= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
