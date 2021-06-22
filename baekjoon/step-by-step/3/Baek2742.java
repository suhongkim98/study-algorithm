import java.util.*;
//https://www.acmicpc.net/problem/2742
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = n ; i > 0 ; i--) {
            System.out.println(i);
        }
        scanner.close();
    }
}
