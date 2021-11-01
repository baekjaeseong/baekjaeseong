import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int m = sc.nextInt();
		int[] arr = new int[m+1];
		int[] arr_2 = new int[m+1];

		for(int i= 0;i<n;i++){
			int x = sc.nextInt();
			if(i%2==1){
					arr_2[x]++;
			}
			else
			{
					arr[x]++;
			}
		}
		for(int i = m-1;i>0;i--){
			arr[i]+=arr[i+1];
			arr_2[i]+=arr_2[i+1];
		}
		for(int i = 1;i<m+1;i++){
			arr[i] +=arr_2[m-i+1];
		}
		int mi = 1;
		arr[0] = 999999999;
		Arrays.sort(arr);
		for(int i = 1 ;i<m+1;i++){
			if(arr[i]==arr[0])
				mi++;
			else
				break;
		}
		System.out.println(arr[0]+" "+mi);
	}
}
