import java.util.*;
//https://www.acmicpc.net/problem/4344
public class Main{
    
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        double[] arr = new double[scanner.nextInt()];
        
        for(int i = 0 ; i < arr.length ; i++) {
            int[] scores = new int[scanner.nextInt()];
            double total = 0;
            double avg = 0;
            for(int j = 0 ; j < scores.length ; j++) {
                scores[j] = scanner.nextInt();
                total += scores[j];
            }
            avg = total / scores.length;
            int count = 0;
            for(int k = 0 ; k < scores.length ; k++) {
                if(scores[k] > avg) {
                    count++;
                }
            }
            arr[i] = (count / (double)scores.length) * 100;
        }
        
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.println(String.format("%.3f", arr[i]) + "%");
        }
        scanner.close();
    }
}
