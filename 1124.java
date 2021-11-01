import java.util.*;
class Main{
	static boolean[] check = new boolean[100001];
	static int[] arr = new int[100001];
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		check[0] = false;
		check[1] = false;
		check[2] = true;
		check[3] = true;
		arr[2] = 1;
		arr[3] = 1;
		for(int i = 4;i<100001;i++){
			int k = i;
			int a = 0;
			int sum = 0;
			for(int j=2;j<=Math.sqrt(k);j++){
				while(k%j==0){
					k=k/j;
					sum++;
				}
			}
			if(k!=1)
				sum++;
			arr[i] = sum;
			if(arr[i]==1){
				check[i] = true;
			}
		}
		int sum =0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i=a;i<=b;i++){
			if(check[arr[i]]==true){
				sum++;
			}
		}
		System.out.println(sum);
	}
}
