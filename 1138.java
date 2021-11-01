import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =new int[n];
		int[] result = new int[n];
		
		for(int i = 0; i<n;i++){
			arr[i] = sc.nextInt();
			result[i] = -1;
		}
		for(int i = 0; i<n;i++){
			int x = 0;
			int k = 0;
			while(true){
				if(k==arr[i]&&result[x]==-1)
					break;
				if(result[x]==-1){
					x++;
					k++;
				}
				else
					x++;
			}
			result[x] = i+1;
		}
		for(int i = 0; i<n;i++){
			System.out.printf("%d ",result[i]);
		}
	}
}
		

