import java.util.*;
//https://www.acmicpc.net/problem/2839
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int[] sugar = {3, 5};
        int n = scanner.nextInt();
        int result = -1;
        for(int i = 0 ; i < n / sugar[0] + 1 ; i++) {
            for(int j = 0 ; j < n / sugar[1] + 1 ; j++) {
                if(sugar[0] * i + sugar[1] * j == n) {
                    result = i + j;
                    break;
                }
            }
            if(result != -1) {
                break;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
