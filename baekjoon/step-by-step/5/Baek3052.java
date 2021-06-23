import java.util.*;
//https://www.acmicpc.net/problem/3052
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int count[] = new int[42];
        int result = 0;
        for(int i = 0 ; i < 10 ; i++){
            int input = scanner.nextInt();
            count[input % 42]++;
        }
        for(int i = 0 ; i < count.length ; i++) {
            if(count[i] != 0) {
                result++;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
