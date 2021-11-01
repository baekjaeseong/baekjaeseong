import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] arr = new int[10];
		while(x!=0){
			int k = x%10;
			arr[k]++;
			x/=10;
		}
		arr[6]+=arr[9];
		arr[6] = (arr[6]+1)/2;
		int max = 0;
		for(int i = 0 ; i<9;i++){
			if(arr[i]>max)
				max=arr[i];
		}
		System.out.println(max);
	}
}
