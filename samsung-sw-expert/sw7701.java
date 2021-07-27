import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int n = sc.nextInt();
		    String[] arr = new String[n];
		    for(int i = 0 ; i < n ; i++) {
		        arr[i] = sc.next();
		    }
		    Arrays.sort(arr, new Comparator<String>() { 
		        @Override 
		        public int compare(String o1, String o2) { 
		            if(o1.length() < o2.length()) {
		                return -1;
		            } else if(o1.length() > o2.length()) {
		                return 1;
		            }
		            return o1.compareTo(o2); 
		        } });
		    System.out.println("#" + test_case);
		    String before = "";
		    for(int i = 0 ; i < n ; i++) {
		        if(before.equals(arr[i])) continue;
		        before = arr[i];
		        System.out.println(arr[i]);
		    }
		}
	}
}
