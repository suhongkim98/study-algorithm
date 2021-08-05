
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

//최대힙, 최소힙을 둘 다 사용해 중간값 구하기
public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int size = sc.nextInt();
		    int start = sc.nextInt();
		    int sum = 0;
		    PriorityQueue<Integer> minpq = new PriorityQueue<>();
		    PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
		    maxpq.add(start);
		    
		    for(int i = 0 ; i < size ; i++) {
		        int n1 = sc.nextInt();
		        int n2 = sc.nextInt();
		        maxpq.add(n1);
		        maxpq.add(n2);
		        
		        minpq.add(maxpq.poll());
		        if(maxpq.peek() > minpq.peek()) {
		            int maxpqVal = maxpq.poll();
		            int minpqVal = minpq.poll();
		            minpq.add(maxpqVal);
		            maxpq.add(minpqVal);
		            
		        }
                sum += maxpq.peek();
                sum = sum % 20171109;
		    }
		    System.out.println("#" + test_case + " " + sum);
		}
	}
}
