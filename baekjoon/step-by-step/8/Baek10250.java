import java.util.*;
//https://www.acmicpc.net/problem/10250
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0 ; i < T ; i++) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int N = scanner.nextInt();
            int floor = 0, room = 0;
            if(N % H == 0) {
                floor = H;
            } else {
                floor = N % H;
            }
            room = ((N - 1) / H) + 1;
            
            System.out.println(floor + String.format("%02d", room));
        }
        scanner.close();
    }
}
