import java.util.*;
class Main{
	static String[] ar ;
	static int[] tem;
	static int N;
	static int[] sum;
	static void sss(){
		for(int i =0; i<N;i++){
			for(int j = i+1; j<N;j++){
				if(tem[i]==tem[j]){
					//System.out.println(sum[i]+" "+sum[j]);
				//	if((sum[i]==0||sum[j]==0)||(sum[i]==sum[j])){
					if((sum[i]==sum[j])){
						int x = 0;
						while(ar[i].charAt(x)==ar[j].charAt(x)){
							x++;
							if(x==tem[i]||x==tem[j])
								break;
						}
						if(ar[i].charAt(x)>ar[j].charAt(x)){
							
					int temp = tem[i];
					tem[i] = tem[j];
					tem[j] = temp;
					temp = sum[i];
					sum[i] = sum[j];
					sum[j] = temp;
					String arr = ar[i];
					ar[i] = ar[j];
					ar[j] =arr;
					//System.out.println(i+" " +j);
					//i++;
					//j = N;
						}

					}
				}
			}
		}

	}
	static void str(){
		for(int i =0; i<N;i++){
			for(int j = i+1; j<N;j++){
//				System.out.println(ar[i]+" "+tem[i]);
//				System.out.println(ar[j]+" "+tem[j]);
				if(tem[i]>tem[j]){
					int temp = tem[i];
					tem[i] = tem[j];
					tem[j] = temp;
					String arr = ar[i];
					ar[i] = ar[j];
//				System.out.println(ar[i]+" "+tem[i]);
//				System.out.println(ar[j]+" "+tem[j]);
					ar[j] =arr;
//				System.out.println(ar[i]+" "+tem[i]);
//				System.out.println(ar[j]+" "+tem[j]);
				}
			}
		}
	}
	static void st(){
		for(int i =0; i<N;i++){
			for(int j = 0; j<tem[i];j++){
//				System.out.println(ar[i]+" "+tem[i]);
				if(ar[i].charAt(j)>='0'&&ar[i].charAt(j)<='9')
				sum[i] += ar[i].charAt(j)-48;
			}
//			System.out.println(ar[i]);
//				System.out.println(sum[i]);
		}
		for(int i =0; i<N;i++){
			for(int j = i+1; j<N;j++){
				if(tem[i]==tem[j]){
					//if((sum[i]>sum[j])&&(sum[i]!=0&&sum[j]!=0)){
					if((sum[i]>sum[j])){

						int temp = tem[i];
						tem[i] = tem[j];
						tem[j] = temp;
						temp = sum[i];
						sum[i] = sum[j];
						sum[j] = temp;
						String arr = ar[i];
						ar[i] = ar[j];
						ar[j] =arr;
					}
				}
			}
		}


	}
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		ar = new String[N];
		tem = new int[N];
		sum = new int[N];
		for(int i = 0; i<N;i++){
			ar[i] = sc.next();
			tem[i] = ar[i].length();
		}
		str();
		st();
		sss();
		for(int i = 0; i<N;i++){
			System.out.println(ar[i]);
		}
	}
}

