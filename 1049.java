import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = 999999999;
		int[][]arr = new int[M][2];
		int mi =min;
		for(int i = 0; i<M;i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			if(mi>arr[i][0])
				mi = arr[i][0];
			if(mi>arr[i][1]*6)
				mi=arr[i][1]*6;
		}
		for(int i = 0; i<M;i++){
			int c =0;
			int d = N;
			while(d>6){
				c++;
				d-=6;
			}
			int sum = c*mi+d*arr[i][1];
			if(sum>((c+1)*mi))
				sum = (c+1)*mi;
			if(sum<min)
				min=sum;
		//	System.out.println(sum+" "+d+ " "+c+ " "+min+" "+sum+" "+arr[i][1]);
		}

		System.out.println(min);
	}
}
