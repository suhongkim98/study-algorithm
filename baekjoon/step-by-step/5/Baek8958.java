import java.util.*;
//https://www.acmicpc.net/problem/8958
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String arr[] = new String[scanner.nextInt()];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = scanner.next();
        }
        for(int i = 0 ; i < arr.length ; i++) {
            int score = 1;
            int total = 0;
            for(int j = 0 ; j < arr[i].length() ; j++){
                if(arr[i].charAt(j) == 'O') {
                    total += score++;
                } else {
                    score = 1;
                }
            }
            System.out.println(total);
        }
        scanner.close();
    }
}
