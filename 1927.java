import java.util.*;
class Main{
	static int INT = 2147483646;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[100003];
		boolean[] visit = new boolean[100003];
		int j = 0;
		int head = 0;
		int k,x,i;
		System.out.println(n);
		for(i = 0; i<arr.length;i++){
			arr[i] = INT;
		}
		for(i = 0; i<n;i++){
			k = sc.nextInt();
			if(k==0){
				int min = INT;
				int abc = INT;
				for(int e=j; e<head;e++){
					if(arr[e]<min){
						abc=e;
						min=arr[e];
					}
				}
				if(min==INT)
					System.out.println(0);
				else{
				System.out.println(min);
				}
				
				
				if(abc!=INT){
					arr[abc] = arr[j++];
				}
			}
			else
			{
				arr[head+j] = k;
				head++;
			}
		}
	}
}



